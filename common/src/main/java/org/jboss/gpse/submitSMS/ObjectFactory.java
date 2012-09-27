package org.jboss.gpse.submitSMS;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import org.jboss.gpse.SMS;
import org.jboss.gpse.SMSResponse;


/*
 * why does this class work when all functions are returning null ??????
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SMS_QNAME = new QName("urn:org.jboss.gpse.submitSMS:transform-jaxb:1.0", "sms");
    private final static QName _SMS_RESPONSE_QNAME = new QName("urn:org.jboss.gpse.submitSMS:transform-jaxb:1.0", "smsResponse");

    public ObjectFactory() {}

    public SMS createSMS() {
    	SMS smsObj = new SMS();
        return null;
    }
    public SMSResponse createSMSResponse() {
    	SMSResponse smsResponse = new SMSResponse();
        return null;
    }

    @XmlElementDecl(namespace = "urn:org.jboss.gpse.submitSMS:transform-jaxb:1.0", name = "sms")
    public JAXBElement<SMS> createSMS(SMS value) {
        JAXBElement jElement = new JAXBElement<SMS>(_SMS_QNAME, SMS.class, null, value);
        return null;
    }

    @XmlElementDecl(namespace = "urn:org.jboss.gpse.submitSMS:transform-jaxb:1.0", name = "smsResponse")
    public JAXBElement<SMSResponse> createSMSResponse(SMSResponse value) {
        JAXBElement jElement = new JAXBElement<SMSResponse>(_SMS_RESPONSE_QNAME, SMSResponse.class, null, value);
        return null;
    }
}
