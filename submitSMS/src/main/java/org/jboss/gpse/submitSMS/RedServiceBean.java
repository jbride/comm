package org.jboss.gpse.submitSMS;

import org.apache.log4j.Logger;
import org.switchyard.component.bean.Service;

@Service(IRedService.class)
public class RedServiceBean implements IRedService {

    private static final Logger LOGGER = Logger.getLogger(RedServiceBean.class);
    
    public void handleRed(SMS smsObj) {
        LOGGER.info("handleRed() Red service processing sms with cpid: " + smsObj.getCpid());
    }

}
