//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.25 at 05:48:09 PM CEST 
//


package es.rickyepoderi.wbxml.bind.wvcsp;

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
    "wvcspFeat"
})
@XmlRootElement(name = "Functions")
public class Functions {

    @XmlElement(name = "WVCSPFeat", required = true)
    protected WVCSPFeat wvcspFeat;

    /**
     * Gets the value of the wvcspFeat property.
     * 
     * @return
     *     possible object is
     *     {@link WVCSPFeat }
     *     
     */
    public WVCSPFeat getWVCSPFeat() {
        return wvcspFeat;
    }

    /**
     * Sets the value of the wvcspFeat property.
     * 
     * @param value
     *     allowed object is
     *     {@link WVCSPFeat }
     *     
     */
    public void setWVCSPFeat(WVCSPFeat value) {
        this.wvcspFeat = value;
    }

}
