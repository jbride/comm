package org.jboss.gpse.submitSMS;

import org.jboss.gpse.SMS;
import org.jboss.gpse.SMSResponse;

public interface ISubmitSMS {

    SMSResponse acceptSMS(SMS smsObj);
    void acceptSMSOneWay(SMS smsObj);
    void health(String payload);

}
