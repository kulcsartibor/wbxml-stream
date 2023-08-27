//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.25 at 05:48:09 PM CEST 
//


package es.rickyepoderi.wbxml.bind.wvcsp;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "userIDOrContactList",
    "presenceSubList"
})
@XmlRootElement(name = "Presence")
public class Presence {

    @XmlElements({
        @XmlElement(name = "UserID", required = true, type = UserID.class),
        @XmlElement(name = "ContactList", required = true, type = ContactList.class)
    })
    protected List<Object> userIDOrContactList;
    @XmlElement(name = "PresenceSubList")
    protected List<PresenceSubList> presenceSubList;

    /**
     * Gets the value of the userIDOrContactList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userIDOrContactList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserIDOrContactList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserID }
     * {@link ContactList }
     * 
     * 
     */
    public List<Object> getUserIDOrContactList() {
        if (userIDOrContactList == null) {
            userIDOrContactList = new ArrayList<Object>();
        }
        return this.userIDOrContactList;
    }

    /**
     * Gets the value of the presenceSubList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the presenceSubList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPresenceSubList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PresenceSubList }
     * 
     * 
     */
    public List<PresenceSubList> getPresenceSubList() {
        if (presenceSubList == null) {
            presenceSubList = new ArrayList<PresenceSubList>();
        }
        return this.presenceSubList;
    }

}
