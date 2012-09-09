package org.jboss.gpse.submitSMS;

public interface ISubmitSMS {

    SMS acceptSMS(SMS smsObj);
    void health(String payload);

}
