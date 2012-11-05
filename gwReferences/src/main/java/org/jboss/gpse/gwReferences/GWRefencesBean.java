package org.jboss.gpse.gwReferences;

import java.net.URL;

import javax.inject.Inject;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.jboss.gpse.SMS;
import org.jboss.gpse.SMSResponse;

import org.jboss.gpse.jaxb.Sms;
import org.jboss.gpse.jaxb.SmsResponse;
import org.jboss.gpse.jaxb.SimpleJaxWsService;

@org.switchyard.component.bean.Service(IGWRefences.class)
public class GWRefencesBean implements IGWRefences {
    
    public SMSResponse helloSMS(SMS smsObject) {
        try{
            Sms clientSms = new Sms();
            QName qname = new QName("urn:org.jboss.gpse:1.0", "SimpleJaxWsService");
            URL url = new URL("http://zareason:8080/pfp-simpleJaxWs/SimpleJaxWsService?wsdl");
            Service service = Service.create(url, qname);
            SimpleJaxWsService wsPort = service.getPort(SimpleJaxWsService.class);
            SmsResponse clientResponse = wsPort.acceptSMS(clientSms);

            SMSResponse sResponse = new SMSResponse();
            return sResponse;
        }catch(Throwable x){
            x.printStackTrace();
            return null;
        }
    }

}
