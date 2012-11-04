package org.jboss.gpse.simpleJaxWs;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.jboss.gpse.SMS;
import org.jboss.gpse.SMSResponse;

@WebService(targetNamespace="http://org.jboss.gpse.simpleJaxWS", serviceName="SimpleJaxWsService", portName="SimpleJaxWsPort")
public class SimpleJaxWsService implements ISimpleJaxWs {
	
	Logger log = Logger.getLogger("SimpleJaxWS");

	public SMSResponse acceptSMS(SMS smsObj) {
		SMSResponse sResponse = new SMSResponse();
		sResponse.setCpid(smsObj.getCpid());
		sResponse.setErrorCode(234);
		log.info("acceptSMS() cpid = "+smsObj.getCpid());
		return null;
	}

}
