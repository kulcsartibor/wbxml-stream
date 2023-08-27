//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.30 at 11:39:15 AM CEST 
//


package es.rickyepoderi.wbxml.bind.syncml;

import java.util.ArrayList;
import java.util.List;
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
    "cmdID",
    "noResp",
    "noResults",
    "cred",
    "target",
    "source",
    "lang",
    "meta",
    "data"
})
@XmlRootElement(name = "Search", namespace="SYNCML:SYNCML1.1")
public class Search {

    @XmlElement(name = "CmdID", namespace="SYNCML:SYNCML1.1", required = true)
    protected String cmdID;
    @XmlElement(name = "NoResp", namespace="SYNCML:SYNCML1.1")
    protected NoResp noResp;
    @XmlElement(name = "NoResults", namespace="SYNCML:SYNCML1.1")
    protected NoResults noResults;
    @XmlElement(name = "Cred", namespace="SYNCML:SYNCML1.1")
    protected Cred cred;
    @XmlElement(name = "Target", namespace="SYNCML:SYNCML1.1")
    protected Target target;
    @XmlElement(name = "Source", namespace="SYNCML:SYNCML1.1", required = true)
    protected List<Source> source;
    @XmlElement(name = "Lang", namespace="SYNCML:SYNCML1.1")
    protected String lang;
    @XmlElement(name = "Meta", namespace="SYNCML:SYNCML1.1", required = true)
    protected Meta meta;
    @XmlElement(name = "Data", namespace="SYNCML:SYNCML1.1", required = true)
    protected String data;

    /**
     * Gets the value of the cmdID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCmdID() {
        return cmdID;
    }

    /**
     * Sets the value of the cmdID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCmdID(String value) {
        this.cmdID = value;
    }

    /**
     * Gets the value of the noResp property.
     * 
     * @return
     *     possible object is
     *     {@link NoResp }
     *     
     */
    public NoResp getNoResp() {
        return noResp;
    }

    /**
     * Sets the value of the noResp property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoResp }
     *     
     */
    public void setNoResp(NoResp value) {
        this.noResp = value;
    }

    /**
     * Gets the value of the noResults property.
     * 
     * @return
     *     possible object is
     *     {@link NoResults }
     *     
     */
    public NoResults getNoResults() {
        return noResults;
    }

    /**
     * Sets the value of the noResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoResults }
     *     
     */
    public void setNoResults(NoResults value) {
        this.noResults = value;
    }

    /**
     * Gets the value of the cred property.
     * 
     * @return
     *     possible object is
     *     {@link Cred }
     *     
     */
    public Cred getCred() {
        return cred;
    }

    /**
     * Sets the value of the cred property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cred }
     *     
     */
    public void setCred(Cred value) {
        this.cred = value;
    }

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link Target }
     *     
     */
    public Target getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link Target }
     *     
     */
    public void setTarget(Target value) {
        this.target = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the source property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Source }
     * 
     * 
     */
    public List<Source> getSource() {
        if (source == null) {
            source = new ArrayList<Source>();
        }
        return this.source;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Gets the value of the meta property.
     * 
     * @return
     *     possible object is
     *     {@link Meta }
     *     
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     * Sets the value of the meta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Meta }
     *     
     */
    public void setMeta(Meta value) {
        this.meta = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setData(String value) {
        this.data = value;
    }

}
