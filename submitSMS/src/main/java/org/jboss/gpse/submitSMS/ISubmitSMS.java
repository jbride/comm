package org.jboss.gpse.submitSMS;

import org.jboss.gpse.SMS;

public interface ISubmitSMS {

    SMS acceptSMS(SMS smsObj);
    void health(String payload);

}
