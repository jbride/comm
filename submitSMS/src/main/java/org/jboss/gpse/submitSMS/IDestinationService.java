package org.jboss.gpse.submitSMS;

import org.jboss.gpse.SMS;

public interface IDestinationService {
    public void determineDestination(SMS smsObj);
}
