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
    "format",
    "type",
    "mark",
    "size",
    "anchor",
    "version",
    "nextNonce",
    "maxMsgSize",
    "maxObjSize",
    "emi",
    "mem"
})
@XmlRootElement(name = "Meta", namespace="SYNCML:SYNCML1.1")
public class Meta {

    @XmlElement(name = "Format", namespace="syncml:metinf")
    protected String format;
    @XmlElement(name = "Type", namespace="syncml:metinf")
    protected String type;
    @XmlElement(name = "Mark", namespace="syncml:metinf")
    protected String mark;
    @XmlElement(name = "Size", namespace="syncml:metinf")
    protected String size;
    @XmlElement(name = "Anchor", namespace="syncml:metinf")
    protected Anchor anchor;
    @XmlElement(name = "Version", namespace="syncml:metinf")
    protected String version;
    @XmlElement(name = "NextNonce", namespace="syncml:metinf")
    protected String nextNonce;
    @XmlElement(name = "MaxMsgSize", namespace="syncml:metinf")
    protected String maxMsgSize;
    @XmlElement(name = "MaxObjSize", namespace="syncml:metinf")
    protected String maxObjSize;
    @XmlElement(name = "EMI", namespace="syncml:metinf")
    protected List<EMI> emi;
    @XmlElement(name = "Mem", namespace="syncml:metinf")
    protected Mem mem;

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the mark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMark() {
        return mark;
    }

    /**
     * Sets the value of the mark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMark(String value) {
        this.mark = value;
    }

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSize(String value) {
        this.size = value;
    }

    /**
     * Gets the value of the anchor property.
     * 
     * @return
     *     possible object is
     *     {@link Anchor }
     *     
     */
    public Anchor getAnchor() {
        return anchor;
    }

    /**
     * Sets the value of the anchor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Anchor }
     *     
     */
    public void setAnchor(Anchor value) {
        this.anchor = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the nextNonce property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextNonce() {
        return nextNonce;
    }

    /**
     * Sets the value of the nextNonce property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextNonce(String value) {
        this.nextNonce = value;
    }

    /**
     * Gets the value of the maxMsgSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxMsgSize() {
        return maxMsgSize;
    }

    /**
     * Sets the value of the maxMsgSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxMsgSize(String value) {
        this.maxMsgSize = value;
    }

    /**
     * Gets the value of the maxObjSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxObjSize() {
        return maxObjSize;
    }

    /**
     * Sets the value of the maxObjSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxObjSize(String value) {
        this.maxObjSize = value;
    }

    /**
     * Gets the value of the emi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the emi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEMI().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EMI }
     * 
     * 
     */
    public List<EMI> getEMI() {
        if (emi == null) {
            emi = new ArrayList<EMI>();
        }
        return this.emi;
    }

    /**
     * Gets the value of the mem property.
     * 
     * @return
     *     possible object is
     *     {@link Mem }
     *     
     */
    public Mem getMem() {
        return mem;
    }

    /**
     * Sets the value of the mem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mem }
     *     
     */
    public void setMem(Mem value) {
        this.mem = value;
    }

}
