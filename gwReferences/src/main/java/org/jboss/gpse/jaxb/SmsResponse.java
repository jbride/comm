
package org.jboss.gpse.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for smsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="smsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cpid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sender" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "smsResponse", propOrder = {
    "cpid",
    "sender",
    "errorCode"
})
public class SmsResponse {

    protected int cpid;
    protected int sender;
    protected int errorCode;

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
     * Gets the value of the errorCode property.
     * 
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     */
    public void setErrorCode(int value) {
        this.errorCode = value;
    }

}
