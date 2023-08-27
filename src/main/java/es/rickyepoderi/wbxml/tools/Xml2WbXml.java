/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *    
 * Linking this library statically or dynamically with other modules 
 * is making a combined work based on this library. Thus, the terms and
 * conditions of the GNU General Public License cover the whole
 * combination.
 *    
 * As a special exception, the copyright holders of this library give 
 * you permission to link this library with independent modules to 
 * produce an executable, regardless of the license terms of these 
 * independent modules, and to copy and distribute the resulting 
 * executable under terms of your choice, provided that you also meet, 
 * for each linked independent module, the terms and conditions of the 
 * license of that module.  An independent module is a module which 
 * is not derived from or based on this library.  If you modify this 
 * library, you may extend this exception to your version of the 
 * library, but you are not obligated to do so.  If you do not wish 
 * to do so, delete this exception statement from your version.
 *
 * Project: github.com/rickyepoderi/wbxml-stream
 * 
 */
package es.rickyepoderi.wbxml.tools;

import es.rickyepoderi.wbxml.definition.WbXmlDefinition;
import es.rickyepoderi.wbxml.definition.WbXmlInitialization;
import es.rickyepoderi.wbxml.document.WbXmlEncoder;
import es.rickyepoderi.wbxml.document.WbXmlVersion;
import es.rickyepoderi.wbxml.stream.WbXmlOutputFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stax.StAXResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * <p>Tool or command class that emulates the libwbxml <em>xml2wbxml</em> 
 * counterpart. This command let the user convert a common XML file into a
 * binary WBXML file.</p>
 * 
 * <h3>NAME</h3>
 * 
 * <p>wbXml2Xml - Convert a XML text file into a common WBXML binary file</p>
 * 
 * <h3>SYNOPSYS</h3>
 * 
 * <p>java -cp wbxml-jaxb-X.X.X.jar es.rickyepoderi.wbxml.tools.WbXml2Xml
 * [-j --jaxb] [-t --type &lt;TYPE&gt;] [-k --keep] [-c --charset &lt;CHARSET&gt;] [-v --version &lt;X.X&gt;] [-d --definition &lt;NAME&gt;] {infile} {outfile}</p>
 * 
 * <h3>DESCRIPTION</h3>
 * 
 * <p>Command that converts a text XML file into a WBXML binary file. It uses
 * an intermediary form to represent the structure and then normal DOM or
 * JAXB techniques are used. In case of JAXB the representation classes 
 * should be provided (the <em>wbxml-stream</em> package does not contain
 * any JAXB classes, some classes were created for a few languages only for
 * testing purposes but they are not packaged in the library).</p>
 * 
 * <p>The following arguments are used:</p>
 * 
 * <ul>
 * <li><p><strong>-j --jaxb</strong>: Use JAXB processing (object representation)
 * instead of normal DOM processing. As it was said JAXB classes are not part 
 * of the <em>wbxml-tream</em> library.</p></li>
 * <li><p><strong>-e --event</strong>: Use the event writer instead of common
 * stream writer implementation.</p></li>
 * <li><p><strong>-t --type</strong>: The type of use of the string table in
 * the encoding. There are three types: <strong>IF_NEEDED</strong> (default,
 * only use the string table if needed), <strong>ALWAYS</strong> (use for all
 * the strings) and <strong>NO</strong> (no use it at all, it can report
 * problems if the encoding needs it).</p></li>
 * <li><p><strong>-k --keep</strong>: Keep the spaces in the values (by
 * default all the string are trimmed).</p></li>
 * <li><p><strong>-v --version</strong>: WBXML version to use: 1.0, 1.1, 1.2, 
 * 1.3 (default).</p></li>
 * <li><p><strong>-c --charset</strong>: Java charset to encode the WbXML 
 * document (default: UTF-8)</p></li>
 * <li><p><strong>-d --definition</strong>: Use a fixed language definition 
 * for the WBXML file. If no one is provided the command tries to guess it
 * using the public identifier of the WBXML file. But if it is unknown (some
 * languages are not standardized, like Microsoft ActiveSync) and no definition 
 * is provided an error is reported.</p>
 * <p>A list of possible language definitions is shown in the usage of the 
 * command.</p></li>
 * <li><p><strong>infile</strong>: XML file to convert, <em>-</em> can be
 * provided to use the standard output.</em>
 * <li><p><strong>outfile</strong>: file to write the resulting WBXML, 
 * <em>-</em> can be provided to use the standard input.</em>
 * </ul>
 * 
 * <h3>EXAMPLES</h3>
 * 
 * <pre>
 * java -cp wbxml-stream-0.1.0.jar es.rickyepoderi.wbxml.tools.Xml2WbXml si.xml si.wbxml
 *     Convert the file si.xml into WBXML and the result is placed in si.wbxml
 * 
 * java -cp wbxml-stream-0.1.0.jar es.rickyepoderi.wbxml.tools.Xml2WbXml -d "SI 1.0" si.xml si.wbxml
 *     Force definition to SI 1.0 
 * 
 * </pre>
 * 
 * @author ricky
 */
final public class Xml2WbXml {
    
    /**
     * The input stream to read the WBXML.
     */
    private InputStream in = null;
    
    /**
     * The output stream to write the XML.
     */
    private OutputStream out = null;
    
    /**
     * Use DOM (default) or the stranger JAXB.
     */
    private boolean useDom = true;
    
    /**
     * The definition to use in the conversion.
     */
    private WbXmlDefinition def = null;
    
    /**
     * type of encoding.
     */
    private WbXmlEncoder.StrtblType type = WbXmlEncoder.StrtblType.IF_NEEDED;
    
    /**
     * skip spaces.
     */
    private boolean skipSpaces = true;
    
    /**
     * Use event writer.
     */
    private boolean event = false;
    
    /**
     * WBXML version to use in the document.
     */
    private WbXmlVersion version = WbXmlVersion.VERSION_1_3;
    
    /**
     * The default charset to use in the encoding.
     */
    private Charset charset = Charset.forName("UTF-8");
    
    /**
     * It prints the usage of the command and the throws a IllegalArgumentException.
     * @param message The message to show previous of the usage part
     */
    private void usage(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(message);
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("java -cp wbxml-jaxb-X.X.X.jar ");
        sb.append(this.getClass().getName());
        sb.append(" [-j --jaxb] [-t --type <TYPE>] [-k --keep] [-d --definition <NAME>] {infile} {outfile}");
        sb.append(System.getProperty("line.separator"));
        sb.append("       -j --jaxb: Use JAXB instead instead default DOM");
        sb.append(System.getProperty("line.separator"));
        sb.append("      -e --event: Use XMLEventWriter instead of the default XMLStreamWriter");
        sb.append(System.getProperty("line.separator"));
        sb.append("                  In order to use JAXB the classes should be generated from the DTD (xjc)");
        sb.append(System.getProperty("line.separator"));
        sb.append("       -t --type: Type of STR table use. Values: IF_NEEDED (default), ALWAYS, NO");
        sb.append(System.getProperty("line.separator"));
        sb.append("       -k --keep: Keep spaces from the XML (default no)");
        sb.append(System.getProperty("line.separator"));
        sb.append("    -v --version: WBXML version to use: 1.0, 1.1, 1.2, 1.3 (default)");
        sb.append(System.getProperty("line.separator"));
        sb.append("    -c --charset: Java charset to encode the WbXML document (default: UTF-8)");
        sb.append(System.getProperty("line.separator"));
        sb.append(" -d --definition: Force definition instead deriving from XML. Current definitions:");
        sb.append(System.getProperty("line.separator"));
        for (WbXmlDefinition d: WbXmlInitialization.getDefinitions()) {
            sb.append(String.format("                  %s", d.getName()));
            sb.append(System.getProperty("line.separator"));
        }
        sb.append("          infile: input XML file (\"-\" means standard input)");
        sb.append(System.getProperty("line.separator"));
        sb.append("         outfile: output WBXML file (\"-\" means standard output)");
        sb.append(System.getProperty("line.separator"));
        throw new IllegalArgumentException(sb.toString());
    }
    
    /**
     * Method that gets the value part of a parameter if it exists. If the
     * array has no more elements usage is called.
     * @param args The list of arguments
     * @param i The current position
     * @return The string of the value
     */
    private String getNext(String[] args, int i) {
        if (args.length > i) {
            return args[i];
        } else {
            usage("Invalid invocation.");
        }
        return null;
    }
    
    /**
     * Constructor that creates the command using the arguments passed by the 
     * caller. Usage is used (IllegalArgumentException) if some error
     * is detected in the arguments.
     * @param args The argument list
     * @throws Exception Any error
     */
    private Xml2WbXml(String[] args) throws Exception {
        String infile = null;
        String outfile = null;
        int i = 0;
        if (args.length < 2) {
            usage("Invalid invocation.");
        }
        while (i < args.length) {
            if ("-d".equals(args[i]) || "--definition".equals(args[i])) {
                // use fixed definition
                String defName = getNext(args, ++i);
                this.def = WbXmlInitialization.getDefinitionByName(defName);
                if (this.def == null) {
                    usage(String.format("Invalid definition specified '%s'.", defName));
                }
            } else if ("-j".equals(args[i]) || "--jaxb".equals(args[i])) {
                // use JAXB instead DOM
                this.useDom = false;
            } else if ("-e".equals(args[i]) || "--event".equals(args[i])) {
                // Use the XMLEventWriter
                this.event = true;
            } else if ("-t".equals(args[i]) || "--type".equals(args[i])) {
                // the type of encoding
                String name = getNext(args, ++i);
                try {
                    this.type = WbXmlEncoder.StrtblType.valueOf(name);
                } catch (Exception e) {
                    usage(String.format("Invalid STR type '%s'.", name));
                }
            } else if ("-k".equals(args[i]) || "--keep".equals(args[i])) {
                // use JAXB instead DOM
                this.skipSpaces = false;
            } else if ("-v".equals(args[i]) || "--version".equals(args[i])) {
                String v = getNext(args, ++i);
                this.version = WbXmlVersion.locateVersion(v);
                if (this.version == null) {
                    usage(String.format("Invalid version '%s'. Version should be 1.0, 1.1, 1.2 or 1.3.", v));
                }
            } else if ("-c".equals(args[i]) || "--charset".equals(args[i])) {
                String name = getNext(args, ++i);
                try {
                    this.charset = Charset.forName(name);
                } catch (UnsupportedCharsetException e) {
                    usage(String.format("Unsupported charset '%s'.", name));
                }
            } else {
                if (args.length - i != 2) {
                    usage("Invalid invocation.");
                }
                // the names of the infile and outfile
                infile = getNext(args, i);
                outfile = getNext(args, ++i);
            }
            i++;
        }
        // get the input stream
        if ("-".equals(infile)) {
            in = System.in;
        } else {
            File f = new File(infile);
            if (!f.exists() || !f.canRead()) {
                usage(String.format("Input XML file '%s' is not readable.", infile));
            }
            in = new FileInputStream(f);
        }
        // get the output stream
        if ("-".equals(outfile)) {
            out = System.out;
        } else {
            File f = new File(outfile);
            f.createNewFile();
            if (!f.canWrite()) {
                usage(String.format("Output WBXML file '%s' is not writable.", outfile));
            }
            out = new FileOutputStream(f);
        }
    }
    
    /**
     * Method that executes the command, ie, does the conversion from WBXML
     * to XML.
     * @throws Exception Some error
     */
    private void process() throws Exception {
        XMLStreamWriter xmlStreamWriter = null;
        XMLEventWriter xmlEventWriter = null;
        try {
            // weird parameters for xerces:
            // http://xerces.apache.org/xerces2-j/features.html#namespaces
            DocumentBuilderFactory domFact = DocumentBuilderFactory.newInstance();
            domFact.setNamespaceAware(true);
            domFact.setIgnoringElementContentWhitespace(true);
            domFact.setIgnoringComments(true);
            domFact.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder domBuilder = domFact.newDocumentBuilder();
            Document doc = domBuilder.parse(in);
            Element element = doc.getDocumentElement();
            element.normalize();
            if (def == null) {
                // first try using the PublicId
                if (doc.getDoctype() != null && doc.getDoctype().getPublicId() != null) {
                    def = WbXmlInitialization.getDefinitionByFPI(doc.getDoctype().getPublicId());
                }
                // if not using the root element
                if (def == null) {
                    def = WbXmlInitialization.getDefinitionByRoot(
                            element.getLocalName(), element.getNamespaceURI());
                    if (def == null) {
                        usage(String.format("Definition not found for name=%s and namespace=%s. Use -d argument to force it.",
                                element.getLocalName(), element.getNamespaceURI()));
                    }
                }
            }
            // create the factory
            XMLOutputFactory fact = new WbXmlOutputFactory();
            fact.setProperty(WbXmlOutputFactory.DEFINITION_PROPERTY, def);
            fact.setProperty(WbXmlOutputFactory.ENCODING_TYPE_PROPERTY, type);
            fact.setProperty(WbXmlOutputFactory.SKIP_SPACES_PROPERTY, skipSpaces);
            fact.setProperty(WbXmlOutputFactory.VERSION_PROPERTY, version);
            if (!useDom) {
                // use JAXB
                String clazz = def.getClazz();
                if (clazz == null || clazz.isEmpty()) {
                    usage(String.format("The definition '%s' does not contain a main class.",
                            def.getName()));
                }
                JAXBContext jc = JAXBContext.newInstance(Class.forName(clazz));
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                Object obj = unmarshaller.unmarshal(doc);
                Marshaller marshaller = jc.createMarshaller();
                if (event) {
                    xmlEventWriter = fact.createXMLEventWriter(out, charset.name());
                    marshaller.marshal(obj, xmlEventWriter);
                } else {
                    xmlStreamWriter = fact.createXMLStreamWriter(out, charset.name());
                    marshaller.marshal(obj, xmlStreamWriter);
                }
            } else {
                // use common DOM processing
                Transformer xformer = TransformerFactory.newInstance().newTransformer();
                xformer.setOutputProperty(OutputKeys.ENCODING, charset.name());
                Source domSource = new DOMSource(doc);
                StAXResult staxResult;
                if (event) {
                    xmlEventWriter = fact.createXMLEventWriter(out, charset.name());
                    staxResult = new StAXResult(xmlEventWriter);
                } else {
                    xmlStreamWriter = fact.createXMLStreamWriter(out, charset.name());
                    staxResult = new StAXResult(xmlStreamWriter);
                }
                xformer.transform(domSource, staxResult);
            }
        } finally {
            if (xmlStreamWriter != null) {
                try {xmlStreamWriter.close();} catch (Exception e) {}
            }
            if (xmlEventWriter != null) {
                try {xmlEventWriter.close();} catch (Exception e) {}
            }
        }
    }
    
    /**
     * It closes all the streams.
     */
    private void close() {
        try {in.close();} catch(Exception e) {}
        try {out.close();} catch(Exception e) {}
    }
    
    /**
     * Execution of the command. Usage is used if the arguments are incorrect.
     * @param args The arguments to call the command
     * @throws Exception Some error in the invocation
     */
    static public void main(String args[]) throws Exception {
        Xml2WbXml command = null;
        try {
            command = new Xml2WbXml(args);
            command.process();
        } finally {
            if (command != null) {
                command.close();
            }
        }
    }
    
}
