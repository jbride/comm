
package org.jboss.gpse.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jboss.gpse.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SmsResponse_QNAME = new QName("urn:org.jboss.gpse:1.0", "smsResponse");
    private final static QName _AcceptSMSResponse_QNAME = new QName("urn:org.jboss.gpse:1.0", "acceptSMSResponse");
    private final static QName _AcceptSMS_QNAME = new QName("urn:org.jboss.gpse:1.0", "acceptSMS");
    private final static QName _Sms_QNAME = new QName("urn:org.jboss.gpse:1.0", "sms");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jboss.gpse.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AcceptSMSResponse }
     * 
     */
    public AcceptSMSResponse createAcceptSMSResponse() {
        return new AcceptSMSResponse();
    }

    /**
     * Create an instance of {@link SmsResponse }
     * 
     */
    public SmsResponse createSmsResponse() {
        return new SmsResponse();
    }

    /**
     * Create an instance of {@link Sms }
     * 
     */
    public Sms createSms() {
        return new Sms();
    }

    /**
     * Create an instance of {@link AcceptSMS }
     * 
     */
    public AcceptSMS createAcceptSMS() {
        return new AcceptSMS();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SmsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:org.jboss.gpse:1.0", name = "smsResponse")
    public JAXBElement<SmsResponse> createSmsResponse(SmsResponse value) {
        return new JAXBElement<SmsResponse>(_SmsResponse_QNAME, SmsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcceptSMSResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:org.jboss.gpse:1.0", name = "acceptSMSResponse")
    public JAXBElement<AcceptSMSResponse> createAcceptSMSResponse(AcceptSMSResponse value) {
        return new JAXBElement<AcceptSMSResponse>(_AcceptSMSResponse_QNAME, AcceptSMSResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcceptSMS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:org.jboss.gpse:1.0", name = "acceptSMS")
    public JAXBElement<AcceptSMS> createAcceptSMS(AcceptSMS value) {
        return new JAXBElement<AcceptSMS>(_AcceptSMS_QNAME, AcceptSMS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:org.jboss.gpse:1.0", name = "sms")
    public JAXBElement<Sms> createSms(Sms value) {
        return new JAXBElement<Sms>(_Sms_QNAME, Sms.class, null, value);
    }

}
