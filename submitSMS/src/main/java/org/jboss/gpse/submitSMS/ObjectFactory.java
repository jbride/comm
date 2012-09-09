package org.jboss.gpse.submitSMS;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _SMS_QNAME = new QName("urn:org.jboss.gpse.submitSMS:transform-jaxb:1.0", "SMS");
    private final static QName _SMSResponse_QNAME = new QName("urn:org.jboss.gpse.submitSMS:transform-jaxb:1.0", "SMSResponse");

    public ObjectFactory() {
    }

    public SMS createSMS() {
        return new SMS();
    }
    public SMSResponse createSMSResponse() {
        return new SMSResponse();
    }

    @XmlElementDecl(namespace = "urn:org.jboss.gpse.submitSMS:transform-jaxb:1.0", name = "SMS")
    public JAXBElement<SMS> createSMS(SMS value) {
        return new JAXBElement<SMS>(_SMS_QNAME, SMS.class, null, value);
    }
    @XmlElementDecl(namespace = "urn:org.jboss.gpse.submitSMS:transform-jaxb:1.0", name = "SMSResponse")
    public JAXBElement<SMSResponse> createSMSResponse(SMSResponse value) {
        return new JAXBElement<SMSResponse>(_SMSResponse_QNAME, SMSResponse.class, null, value);
    }
}
