package org.jboss.gpse.submitMMS;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import org.apache.log4j.Logger;

import org.jboss.gpse.MMS;
import org.jboss.gpse.MMSResponse;

import org.jboss.gpse.MMS;
import org.jboss.gpse.MMSResponse;

@Service(ISubmitMMS.class)
public class SubmitMMSBean implements ISubmitMMS {

    private static Logger log = Logger.getLogger("SubmitMMSBean");

    public MMS acceptMMS(MMS mmsObj) {
        log.info("acceptMMS() mms = "+mmsObj);
        //MMSResponse mmsResponse = new MMSResponse();
        //mmsObj.setMmsResponse(mmsResponse);
        mmsObj = new MMS();
        return mmsObj;
    }
}
