package org.jboss.gpse.gwReferences;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import org.jboss.gpse.SMS;
import org.jboss.gpse.SMSResponse;
import org.jboss.gpse.submitSMS.ISubmitSMS;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

@Service(IInvokeGWReference.class)
public class InvokeGWReference implements IInvokeGWReference {

    private static Logger log = Logger.getLogger("InvokeGWReference");

    @Inject
    @Reference
    private ISubmitSMS submitSMSReference;
    
    @Override
    public SMSResponse invokeGWReference(SMS smsObj) {
        log.info("acceptSMS() sms = "+smsObj);
        smsObj = new SMS();
        smsObj.setCpid(12345);
        smsObj.setText("werwer");
        SMSResponse smsResponse = new SMSResponse();
        if(smsObj != null) {
            smsObj.setSmsResponse(smsResponse);
            smsResponse = submitSMSReference.acceptSMS(smsObj);
        }
        return smsResponse;
    }

}
