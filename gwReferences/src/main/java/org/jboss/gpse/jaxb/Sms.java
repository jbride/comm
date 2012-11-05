
package org.jboss.gpse.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sms complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sms">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cpid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sender" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="senderS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sms", propOrder = {
    "cpid",
    "sender",
    "senderS",
    "text"
})
public class Sms {

    protected int cpid;
    protected int sender;
    @XmlElement(required = true)
    protected String senderS;
    @XmlElement(required = true)
    protected String text;

    /**
     * Gets the value of the cpid property.
     * 
     */
    public int getCpid() {
        return cpid;
    }

    /**
     * Sets the value of the cpid property.
     * 
     */
    public void setCpid(int value) {
        this.cpid = value;
    }

    /**
     * Gets the value of the sender property.
     * 
     */
    public int getSender() {
        return sender;
    }

    /**
     * Sets the value of the sender property.
     * 
     */
    public void setSender(int value) {
        this.sender = value;
    }

    /**
     * Gets the value of the senderS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderS() {
        return senderS;
    }

    /**
     * Sets the value of the senderS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderS(String value) {
        this.senderS = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

}
