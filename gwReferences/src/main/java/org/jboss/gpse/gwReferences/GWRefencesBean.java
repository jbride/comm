package org.jboss.gpse.gwReferences;

import javax.inject.Inject;

import org.jboss.gpse.SMS;
import org.jboss.gpse.SMSResponse;
import org.jboss.gpse.simpleJaxWs.ISimpleJaxWs;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

@Service(IGWRefences.class)
public class GWRefencesBean implements IGWRefences {
	
	@Inject
	@Reference
	private ISimpleJaxWs jaxWsService;

	public SMSResponse helloSMS(SMS smsObject) {
		SMSResponse sResponse = jaxWsService.acceptSMS(smsObject);
		return sResponse;
	}

}
