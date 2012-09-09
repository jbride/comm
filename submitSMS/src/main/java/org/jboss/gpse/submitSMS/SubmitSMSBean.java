package org.jboss.gpse.submitSMS;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import org.apache.log4j.Logger;

@Service(ISubmitSMS.class)
public class SubmitSMSBean implements ISubmitSMS {

    private static Logger log = Logger.getLogger("SubmitSMSBean");

    @Inject
    @Reference
    private ISMSRequestValidation smsRequestValidationService;

    @Inject
    @Reference
    private IRoutingService rService;

    public SMS acceptSMS(SMS smsObj) {
        log.info("acceptSMS() sms = "+smsObj);
        SMSResponse smsResponse = new SMSResponse();
        smsObj.setSmsResponse(smsResponse);
        smsRequestValidationService.executeValidation(smsObj);
        if(smsResponse.getErrorCode() != SMSResponse.STATUS_GOOD) {
            log.info("acceptSMS() errorCode = "+smsResponse.getErrorCode());
            return smsObj;
        }else {
            rService.processRoute(smsObj);
            return smsObj;
        }
    }

    public void health(String payload){
        System.out.println("Great Success. payload = "+payload);
    }

}
