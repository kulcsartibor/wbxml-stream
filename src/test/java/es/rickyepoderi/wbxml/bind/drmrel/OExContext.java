//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.29 at 02:56:01 PM CEST 
//


package es.rickyepoderi.wbxml.bind.drmrel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "oDdVersion",
    "oDdUid"
})
@XmlRootElement(name = "context", namespace="http://odrl.net/1.1/ODRL-EX")
public class OExContext {

    @XmlElement(name = "version", namespace="http://odrl.net/1.1/ODRL-DD")
    protected String oDdVersion;
    @XmlElement(name = "uid", namespace="http://odrl.net/1.1/ODRL-DD")
    protected String oDdUid;

    /**
     * Gets the value of the oDdVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getODdVersion() {
        return oDdVersion;
    }

    /**
     * Sets the value of the oDdVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setODdVersion(String value) {
        this.oDdVersion = value;
    }

    /**
     * Gets the value of the oDdUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getODdUid() {
        return oDdUid;
    }

    /**
     * Sets the value of the oDdUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setODdUid(String value) {
        this.oDdUid = value;
    }

}
