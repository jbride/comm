package org.jboss.gpse.submitSMS;

import org.apache.log4j.Logger;
import org.jboss.gpse.SMS;
import org.switchyard.component.bean.Service;

@Service(IGreenService.class)
public class GreenServiceBean implements IGreenService {

    private static final Logger LOGGER = Logger.getLogger(GreenServiceBean.class);
    
    public void handleGreen(SMS smsObj) {
        LOGGER.info("handleGreen() Green service processing widget with id: " + smsObj.getCpid());
    }

}
