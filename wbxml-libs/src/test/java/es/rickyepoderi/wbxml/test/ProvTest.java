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
package es.rickyepoderi.wbxml.test;

import com.google.common.io.CharSource;
import com.xpo.wbxml.definition.WbXmlInitialization;
import es.rickyepoderi.wbxml.document.WbXmlEncoder;
import es.rickyepoderi.wbxml.document.WbXmlEncoder.StrtblType;
import es.rickyepoderi.wbxml.document.WbXmlVersion;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author ricky
 */
public class ProvTest extends GenericDirectoryTester {
    
    public ProvTest() {
        super("src/test/examples/prov",
                WbXmlInitialization.getDefinitionByName("PROV 1.0"));
    }
    
    @Test(groups = {"xml", "prov", "type-if-needed", "stream" })
    public void testXmlStreamIfNeeded() throws Exception {
        testXmlDirectory(WbXmlEncoder.StrtblType.IF_NEEDED, true, false);
    }
    
    @Test(groups = {"xml", "prov", "type-always", "stream" })
    public void testXmlStreamAllways() throws Exception {
        testXmlDirectory(WbXmlEncoder.StrtblType.ALWAYS, true, false);
    }
    
    @Test(groups = {"xml", "prov", "type-no", "stream" })
    public void testXmlStreamNo() throws Exception {
        testXmlDirectory(WbXmlEncoder.StrtblType.NO, true, false);
    }
    
    @Test(groups = {"wbxml", "prov", "type-if-needed", "stream" })
    public void testWbXMLStreamIfNeeded() throws Exception {
        testWbXmlDirectory(WbXmlEncoder.StrtblType.IF_NEEDED, true, false);
    }
    
    @Test(groups = {"wbxml", "prov", "type-if-always", "stream" })
    public void testWbXMLStreamAllways() throws Exception {
        testWbXmlDirectory(WbXmlEncoder.StrtblType.ALWAYS, true, false);
    }
    
    @Test(groups = {"wbxml", "sl", "type-no", "stream" })
    public void testWbXMLStreamNo() throws Exception {
        testWbXmlDirectory(WbXmlEncoder.StrtblType.NO, true, false);
    }
    
    
    
    @Test(groups = {"xml", "prov", "type-if-needed", "event" })
    public void testXmlEventIfNeeded() throws Exception {
        testXmlDirectory(WbXmlEncoder.StrtblType.IF_NEEDED, true, true);
    }
    
    @Test(groups = {"xml", "prov", "type-always", "event" })
    public void testXmlEventAllways() throws Exception {
        testXmlDirectory(WbXmlEncoder.StrtblType.ALWAYS, true, true);
    }
    
    @Test(groups = {"xml", "prov", "type-no", "event" })
    public void testXmlEventNo() throws Exception {
        testXmlDirectory(WbXmlEncoder.StrtblType.NO, true, true);
    }
    
    @Test(groups = {"wbxml", "prov", "type-if-needed", "event" })
    public void testWbXMLEventIfNeeded() throws Exception {
        testWbXmlDirectory(WbXmlEncoder.StrtblType.IF_NEEDED, true, true);
    }
    
    @Test(groups = {"wbxml", "prov", "type-if-always", "event" })
    public void testWbXMLEventAllways() throws Exception {
        testWbXmlDirectory(WbXmlEncoder.StrtblType.ALWAYS, true, true);
    }
    
    @Test(groups = {"wbxml", "sl", "type-no", "event" })
    public void testWbXMLEventNo() throws Exception {
        testWbXmlDirectory(WbXmlEncoder.StrtblType.NO, true, true);
    }


    @Test(groups = {"xml", "prov", "type-if-needed", "event" })
    public void testStaticWbXml() throws Exception {
        String xmlContent = "<?xml version='1.0' encoding='UTF-8' ?>\n" +
                "<!DOCTYPE wap-provisioningdoc PUBLIC \"-//WAPFORUM//DTD PROV 1.0//EN\" \"http://www.wapforum.org/DTD/prov.dtd\">\n" +
                "<wap-provisioningdoc>\n" +
                "    <characteristic type=\"BOOTSTRAP\">\n" +
                "        <parm name=\"NAME\" value=\"PROV1\"/>\n" +
                "    </characteristic>\n" +
                "    <characteristic type=\"NAPDEF\">\n" +
                "        <parm name=\"NAPID\" value=\"INTERNET\" />\n" +
                "        <parm name=\"BEARER\" value=\"GSM-GPRS\" />\n" +
                "        <parm name=\"NAME\" value=\"PROV1\" />\n" +
                "        <parm name=\"NAP-ADDRESS\" value=\"test.apn\" />\n" +
                "        <parm name=\"NAP-ADDRTYPE\" value=\"APN\" />\n" +
                "        <parm name=\"INTERNET\" />\n" +
                "        <characteristic type=\"NAPAUTHINFO\">\n" +
                "            <parm name=\"AUTHTYPE\" value=\"PAP\"/>\n" +
                "            <parm name=\"AUTHNAME\" value=\"user\"/>\n" +
                "            <parm name=\"AUTHSECRET\" value=\"pass\"/>\n" +
                "        </characteristic>\n" +
                "    </characteristic>\n" +
                "</wap-provisioningdoc>";


        try(InputStream in = CharSource.wrap(xmlContent)
                                            .asByteSource(StandardCharsets.UTF_8)
                                            .openBufferedStream()){

            DocumentBuilderFactory domFact = DocumentBuilderFactory.newInstance();
            domFact.setNamespaceAware(true);
            domFact.setIgnoringElementContentWhitespace(true);
            domFact.setIgnoringComments(true);
            domFact.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder domBuilder = domFact.newDocumentBuilder();
            Document doc = domBuilder.parse(in);
            doc.normalizeDocument();


            byte[] bytes  = doc2WbXml(doc, def, WbXmlVersion.VERSION_1_3, StrtblType.ALWAYS, true, true);

//            Files.write(Paths.get("/Users/kulcsart/Repos/Rocam/temp/j.wbxml"), bytes);


            Document doc2 = wbxml2doc(bytes, def, true);


//            printDocument(doc2, System.out);

            System.out.println(doc2);


        } catch (Exception e){
            throw e;
        }



    }

    public static void printDocument(Document doc, OutputStream out) throws IOException, TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        transformer.transform(new DOMSource(doc),
                new StreamResult(new OutputStreamWriter(out, "UTF-8")));
    }

}
