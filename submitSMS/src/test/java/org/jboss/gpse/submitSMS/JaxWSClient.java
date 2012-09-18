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
    private static Logger log = Logger.getLogger(JaxWSClient.class);
    private static String wsdlUrl = "http://zareason:8080/submitSMS/ISubmitSMS?wsdl";
    private static String namespaceURI = "urn:org.jboss.gpse.submitSMS:transform-jaxb:1.0";
    private static String serviceName = "ISubmitSMS";
    private static int loops = 1;

    public static void main(String[] args){
        String wsdlUrlProp = System.getProperty(WSDL_URL);
        if(wsdlUrlProp != null)
            wsdlUrl = wsdlUrlProp;
        log.info("main() wsdlUrl = "+wsdlUrl);

	try {
            QName qname = new QName(namespaceURI, serviceName);
            URL url = new URL(wsdlUrl);
            Service service = Service.create(url, qname); 
            SubmitSMSPortType wsPort = service.getPort(SubmitSMSPortType.class);
            ((BindingProvider)wsPort).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
            ((BindingProvider)wsPort).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "admin");

            Sms smsObj = new Sms();
            smsObj.setCpid(1);
            SmsResponse response = wsPort.acceptSMS(smsObj);
            log.info("main() response = "+response);
	} catch (Exception x) {
		x.printStackTrace();
	}
    }

}
