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
    "subgcn",
    "grchn"
})
@XmlRootElement(name = "GroupUseFunc")
public class GroupUseFunc {

    @XmlElement(name = "SUBGCN")
    protected SUBGCN subgcn;
    @XmlElement(name = "GRCHN")
    protected GRCHN grchn;

    /**
     * Gets the value of the subgcn property.
     * 
     * @return
     *     possible object is
     *     {@link SUBGCN }
     *     
     */
    public SUBGCN getSUBGCN() {
        return subgcn;
    }

    /**
     * Sets the value of the subgcn property.
     * 
     * @param value
     *     allowed object is
     *     {@link SUBGCN }
     *     
     */
    public void setSUBGCN(SUBGCN value) {
        this.subgcn = value;
    }

    /**
     * Gets the value of the grchn property.
     * 
     * @return
     *     possible object is
     *     {@link GRCHN }
     *     
     */
    public GRCHN getGRCHN() {
        return grchn;
    }

    /**
     * Sets the value of the grchn property.
     * 
     * @param value
     *     allowed object is
     *     {@link GRCHN }
     *     
     */
    public void setGRCHN(GRCHN value) {
        this.grchn = value;
    }

}
