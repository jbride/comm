package org.jboss.gpse.gwReferences;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;

import org.switchyard.annotations.Transformer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.StringReader;

import org.jboss.gpse.SMS;
import org.jboss.gpse.SMSResponse;

public class Transformers {

    // Element names in XML document
    private static final String CPID = "cpid";
    private static final String SENDER = "sender";
    private static final String SENDER_S = "senderS";
    private static final String TEXT = "text";
    private static final String ERROR_CODE="errorCode";

    /**
     * Transform from a DOM element to a SMS instance.
     * <p/>
     * No need to specify the "to" type because Order is a concrete type.
     */
    @Transformer(from = "{urn:org.jboss.gpse.gwReferences:bean-service:1.0}domSMSResponse")
    public SMSResponse transform(Element from) {
    	int cpid = Integer.valueOf(getElementValue(from, CPID));
    	int errorCode = Integer.valueOf(getElementValue(from, ERROR_CODE));
    	SMSResponse smsResponse = new SMSResponse();
    	smsResponse.setCpid(cpid);
    	smsResponse.setErrorCode(errorCode);
        return smsResponse;
    }

    /**
     * Transform from an SMS object to an Element.
     * <p/>
     * No need to specify the "from" type because SMS is a concrete type.
     */
    @Transformer(to = "{urn:org.jboss.gpse.gwReferences:bean-service:1.0}domSMS")
    public Element transform(SMS sms) {
        StringBuffer domXml = new StringBuffer()
            .append("<sms xmlns:orders=\"urn:org.jboss.gpse.gwReferences:bean-service:1.0\">")
            .append("<cpid>" + sms.getCpid() + "</cpid>")
            .append("<sender>" + sms.getSender() + "</sender>")
            .append("<senderS>" + sms.getSenderS() + "</senderS>")
            .append("<text>" + sms.getText() + "</text>")
            .append("</sms>");

        return toElement(domXml.toString());
    }

    /**
     * Returns the text value of a child node of parent.
     */
    private String getElementValue(Element parent, String elementName) {
        String value = null;
        NodeList nodes = parent.getElementsByTagName(elementName);
        if (nodes.getLength() > 0) {
            value = nodes.item(0).getChildNodes().item(0).getNodeValue();
        }
        return value;
    }

    private Element toElement(String xml) {
        DOMResult dom = new DOMResult();
        try {
            TransformerFactory.newInstance().newTransformer().transform(
                    new StreamSource(new StringReader(xml)), dom);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ((Document)dom.getNode()).getDocumentElement();
    }
}
