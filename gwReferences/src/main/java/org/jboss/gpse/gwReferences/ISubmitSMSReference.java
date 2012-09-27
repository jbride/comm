package org.jboss.gpse.gwReferences;

import org.jboss.gpse.SMS;
import org.jboss.gpse.SMSResponse;

public interface ISubmitSMSReference {

    SMSResponse acceptSMS(SMS smsObj); 
}
