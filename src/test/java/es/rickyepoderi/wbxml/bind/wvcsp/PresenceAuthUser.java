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
    "userID",
    "acceptance"
})
@XmlRootElement(name = "PresenceAuth-User")
public class PresenceAuthUser {

    @XmlElement(name = "UserID", required = true)
    protected UserID userID;
    @XmlElement(name = "Acceptance", required = true)
    protected String acceptance;

    /**
     * Gets the value of the userID property.
     * 
     * @return
     *     possible object is
     *     {@link UserID }
     *     
     */
    public UserID getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserID }
     *     
     */
    public void setUserID(UserID value) {
        this.userID = value;
    }

    /**
     * Gets the value of the acceptance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcceptance() {
        return acceptance;
    }

    /**
     * Sets the value of the acceptance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcceptance(String value) {
        this.acceptance = value;
    }

}
