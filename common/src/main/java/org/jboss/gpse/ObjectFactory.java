package org.jboss.gpse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import org.jboss.gpse.SMS;
import org.jboss.gpse.SMSResponse;


/*
 * jaxb classes should have this factory class in the same package as the classes
 * xjc will auto-generate this class
 * if not present, then the following exception is thrown:
 *  Caused by: javax.xml.bind.JAXBException: "org.jboss.gpse." doesnt contain ObjectFactory.class or jaxb.index
 *
 * this class does not appear to be invoked however as evidenced by having all of its functions return null
 *
 * TO-DO: include MMS and MMSResponse factories
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SMS_QNAME = new QName("urn:org.jboss.gpse:1.0", "sms");
    private final static QName _SMS_RESPONSE_QNAME = new QName("urn:org.jboss.gpse:1.0", "smsResponse");

    public ObjectFactory() {}

    public SMS createSMS() {
    	SMS smsObj = new SMS();
        return null;
    }
    public SMSResponse createSMSResponse() {
    	SMSResponse smsResponse = new SMSResponse();
        return null;
    }

    @XmlElementDecl(namespace = "urn:org.jboss.gpse:1.0", name = "sms")
    public JAXBElement<SMS> createSMS(SMS value) {
        JAXBElement jElement = new JAXBElement<SMS>(_SMS_QNAME, SMS.class, null, value);
        return null;
    }

    @XmlElementDecl(namespace = "urn:org.jboss.gpse:1.0", name = "smsResponse")
    public JAXBElement<SMSResponse> createSMSResponse(SMSResponse value) {
        JAXBElement jElement = new JAXBElement<SMSResponse>(_SMS_RESPONSE_QNAME, SMSResponse.class, null, value);
        return null;
    }
}
