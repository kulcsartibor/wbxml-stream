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
    "dsKeyValue"
})
@XmlRootElement(name = "KeyInfo", namespace="http://www.w3.org/2000/09/xmldsig#/")
public class DsKeyInfo {

    @XmlElement(name = "KeyValue", namespace="http://www.w3.org/2000/09/xmldsig#/", required = true)
    protected String dsKeyValue;

    /**
     * Gets the value of the dsKeyValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsKeyValue() {
        return dsKeyValue;
    }

    /**
     * Sets the value of the dsKeyValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsKeyValue(String value) {
        this.dsKeyValue = value;
    }

}
