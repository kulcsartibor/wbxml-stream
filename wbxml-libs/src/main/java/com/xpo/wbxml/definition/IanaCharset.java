package com.xpo.wbxml.definition;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * 
 * <p>Java representation for the IANA charset. The charset in Java does not
 * have the MIB number so it is needed a class that joins Java Charset 
 * with IANA one.</p>
 * 
 * <p>The IANA charset as defined in the following 
 * <a href="http://www.iana.org/assignments/character-sets">link</a>.
 * Not all the charsets in IANA are defined in Java, the following link lists
 * all <a href="http://docs.oracle.com/javase/1.5.0/docs/guide/intl/encoding.doc.html">the charsets defined in JavaSe (version 5)</a>
 * </p>
 * 
 * <p>Not all the charsets are defined here but the idea is simple, just add 
 * the ones you need. ;-)</p>
 *
 * @author Dr. Tibor Kulcsar
 */
public enum IanaCharset {
    UNKNOWN("UNKNOWN", 0, new String[] {}),
    ANSI_X3_4_1968("ANSI_X3.4-1968", 3L, new String[] {"US-ASCII", "iso-ir-6", "ANSI_X3.4-1986", "ISO_646.irv:1991", "ASCII", "ISO646-US", "us", "IBM367", "cp367", "csASCII"}),
    ISO_8859_1_1987("ISO_8859-1:1987", 4L, new String[] {"ISO-8859-1", "iso-ir-100", "ISO_8859-1", "latin1", "l1", "IBM819", "CP819", "csISOLatin1"}),
    ISO_8859_2_1987("ISO_8859-2:1987", 5L, new String[] {"ISO-8859-2", "iso-ir-101", "ISO_8859-2", "latin2", "l2", "csISOLatin2"}),
    ISO_8859_3_1988("ISO_8859-3:1988", 6L, new String[] {"ISO-8859-3", "iso-ir-109", "ISO_8859-3", "latin3", "l3", "csISOLatin3"}),
    ISO_8859_4_1988("ISO_8859-4:1988", 7L, new String[] {"ISO-8859-4", "iso-ir-110", "ISO_8859-4", "latin4", "l4", "csISOLatin4"}),
    ISO_8859_5_1988("ISO_8859-5:1988", 8L, new String[] {"ISO-8859-5"," iso-ir-144", "ISO_8859-5", "cyrillic", "csISOLatinCyrillic"}),
    ISO_8859_6_1987("ISO_8859-6:1987", 9L, new String[] {"ISO-8859-6", "iso-ir-127", "ISO_8859-6", "ECMA-114", "ASMO-708", "arabic", "csISOLatinArabic"}),
    ISO_8859_7_1987("ISO_8859-7:1987", 10L, new String[] {"ISO-8859-7", "iso-ir-126", "ISO_8859-7", "ELOT_928", "ECMA-118", "greek", "greek8", "csISOLatinGreek"}),
    ISO_8859_8_1988("ISO_8859-8:1988", 11L, new String[] {"ISO-8859-8", "iso-ir-138", "ISO_8859-8", "hebrew", "csISOLatinHebrew"}),
    ISO_8859_9_1989("ISO_8859-9:1989", 12L, new String[]{"ISO-8859-9", "iso-ir-148", "ISO_8859-9", "latin5", "l5", "csISOLatin5"}),
    ISO_8859_10("ISO-8859-10", 13L, new String[]{"iso-ir-157", "l6", "ISO_8859-10:1992", "csISOLatin6", "latin6"}),
    SHIFT_JIS("Shift_JIS", 17L, new String[] {"MS_Kanji", "csShiftJIS"}),
    UTF_8("UTF-8", 106L, new String[] {}),
    BIG5("Big5", 2026L, new String[] {"csBig5"}),
    ISO_10646_UCS_2("ISO-10646-UCS-2", 1000L, new String[] {"csUnicode"}),
    UTF_16("UTF-16", 1015L, new String[] {});
    
    /**
     * Logger for the class
     */
    private static final Logger log = Logger.getLogger(IanaCharset.class.getName());
    
    /**
     * Name of the charset.
     */
    private final String name;
    
    /**
     * mib identifier of the IANA charset.
     */
    private final long mibEnum;
    
    /**
     * Alias of the charset.
     */
    private final String[] alias;
    
    /**
     * Java equivalent charset if defined (it defaults to ASCII).
     */
    private Charset charset;
    
    /**
     * static map to search a charset using the name or alias.
     */
    static final Map<String, IanaCharset> charsetAliasMap = new HashMap<>();
    
    /**
     * static map to search the charset using the mib identifier.
     */
    static final Map<Long, IanaCharset> charsetMibMap = new HashMap<>();
    
    /**
     * Private method for the enumeration.
     * @param name The name of the charset
     * @param mibEnum The mib identifier
     * @param alias The list of alias names
     */
    IanaCharset(String name, long mibEnum, String[] alias) {
        this.name = name;
        this.mibEnum = mibEnum;
        this.alias = alias;
        this.charset = null;
    }

    /**
     * Getter for the alias array.
     * @return The alias of the charset
     */
    public String[] getAlias() {
        return alias;
    }

    /**
     * Getter for the MIB identifier.
     * @return The MIB id
     */
    public long getMibEnum() {
        return mibEnum;
    }

    /**
     * Getter for the charset name.
     * @return The name of the charset
     */
    public String getName() {
        return name;
    }
    
    /**
     * Static method to get a charset using the name or any alias.
     * @param alias The name or the alias of the charset to retrieve.
     * @return The associated charset or UNKNOWN.
     */
    public static IanaCharset getIanaCharset(String alias) {
        IanaCharset charset = charsetAliasMap.get(alias.toUpperCase());
        if (charset == null) {
            charset = UNKNOWN;
        }
        return charset;
    }
    
    /**
     * Static method to get a charset using the MIB.
     * @param mib The MIB identifier of teh charset
     * @return The charset associated to this mIB or UNKNOWN
     */
    public static IanaCharset getIanaCharset(long mib) {
        IanaCharset charset = charsetMibMap.get(mib);
        if (charset == null) {
            charset = UNKNOWN;
        }
        return charset;
    }
    
    /**
     * Method to return a Java charset using the name. It is used to 
     * catch the associated exception if the charset is not defined in Java.
     * @param name The name of the charset
     * @return The Java charset or null
     */
    private static Charset getCharsetName(String name) {
        try {
            return Charset.forName(name);
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * Method that search the Java associated Charset to the IANA one. 
     * This method tries to locate the Java charset using the name and all the
     * alias of the charset, if found that Java Charset is returned, if not, it
     * defaults to UTF8.
     * @return The Java associated charset
     */
    public Charset getCharset() {
        if (charset == null) {
            charset = getCharsetName(this.name);
            if (charset == null) {
                for (String a : this.alias) {
                    charset = getCharsetName(a);
                    if (charset != null) {
                        break;
                    }
                }
            }
            if (charset == null) {
                // defaults to UTF-8
                if (mibEnum != 0) {
                    log.log(Level.WARNING, "Iana charset {0} has no Java equivalence", this);
                }
                charset = getCharsetName("UTF-8");
            }
        }
        return charset;
    }
    
    static {
        for (IanaCharset c: IanaCharset.values()) {
            charsetMibMap.put(c.getMibEnum(), c);
            charsetAliasMap.put(c.getName().toUpperCase(), c);
            for (String alias: c.alias) {
                charsetAliasMap.put(alias.toUpperCase(), c);
            }
        }
    }
}
