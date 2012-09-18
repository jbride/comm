package org.jboss.gpse.submitSMS;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import org.jboss.gpse.SMS;
import org.jboss.gpse.SMSResponse;

@XmlRegistry
public class ObjectFactory {

    private final static QName _SMS_QNAME = new QName("urn:org.jboss.gpse.submitSMS:transform-jaxb:1.0", "sms");
    private final static QName _SMS_RESPONSE_QNAME = new QName("urn:org.jboss.gpse.submitSMS:transform-jaxb:1.0", "smsResponse");

    public ObjectFactory() {}

    public SMS createSMS() {
        return new SMS();
    }
    public SMSResponse createSMSResponse() {
        return new SMSResponse();
    }

    @XmlElementDecl(namespace = "urn:org.jboss.gpse.submitSMS:transform-jaxb:1.0", name = "sms")
    public JAXBElement<SMS> createSMS(SMS value) {
        return new JAXBElement<SMS>(_SMS_QNAME, SMS.class, null, value);
    }

    @XmlElementDecl(namespace = "urn:org.jboss.gpse.submitSMS:transform-jaxb:1.0", name = "smsResponse")
    public JAXBElement<SMSResponse> createSMSResponse(SMSResponse value) {
        return new JAXBElement<SMSResponse>(_SMS_RESPONSE_QNAME, SMSResponse.class, null, value);
    }
}
