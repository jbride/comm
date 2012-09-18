package org.jboss.gpse.submitSMS;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import org.jboss.gpse.submitSMS.jaxb.*;

public class JaxWSClient {
    
    private static final String WSDL_URL = "org.jboss.gpse.submitSMS.wsdl.url";
    private static final String TEXT = "org.jboss.gpse.submitSMS.text";
    private static final String CPID = "org.jboss.gpse.submitSMS.cpid";

    private static Logger log = Logger.getLogger(JaxWSClient.class);
    private static String namespaceURI = "urn:org.jboss.gpse.submitSMS:transform-jaxb:1.0";
    private static String serviceName = "ISubmitSMS";

    public static void main(String[] args){
        String wsdlUrl = System.getProperty(WSDL_URL);
        String text = System.getProperty(TEXT);
        String cpid = System.getProperty(CPID);
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("\n\twsdlUrl = ");
        sBuilder.append(wsdlUrl);
        sBuilder.append("\n\ttext = ");
        sBuilder.append(text);
        sBuilder.append("\n\tcpid = ");
        sBuilder.append(cpid);
        log.info("main() properties = "+sBuilder.toString());

	try {
            QName qname = new QName(namespaceURI, serviceName);
            URL url = new URL(wsdlUrl);
            Service service = Service.create(url, qname); 
            SubmitSMSPortType wsPort = service.getPort(SubmitSMSPortType.class);
            ((BindingProvider)wsPort).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
            ((BindingProvider)wsPort).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "admin");

            Sms smsObj = new Sms();
            smsObj.setCpid(Integer.parseInt(cpid));
            smsObj.setText(text);
            SmsResponse response = wsPort.acceptSMS(smsObj);
            log.info("main() response errorCode = "+response.getErrorCode());
	} catch (Exception x) {
		x.printStackTrace();
	}
    }
}
