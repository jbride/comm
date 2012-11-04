package org.jboss.gpse.simpleJaxWs;

import org.jboss.gpse.SMS;
import org.jboss.gpse.SMSResponse;

public interface ISimpleJaxWs {
	SMSResponse acceptSMS(SMS smsObj);

}
