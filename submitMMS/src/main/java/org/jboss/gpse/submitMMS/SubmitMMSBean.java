package org.jboss.gpse.submitMMS;

import org.switchyard.component.bean.Service;

import org.apache.log4j.Logger;

import org.jboss.gpse.MMS;
import org.jboss.gpse.MMSResponse;

@Service(ISubmitMMS.class)
public class SubmitMMSBean implements ISubmitMMS {

    private static Logger log = Logger.getLogger("SubmitMMSBean");

    public MMS acceptMMS(MMS mmsObj) {
        log.info("acceptMMS() will increment the following obj by 1 :  "+mmsObj);
        mmsObj.setCpid(mmsObj.getCpid() +1);
        MMSResponse responseObj = new MMSResponse();
        responseObj.setCpid(mmsObj.getCpid());
        mmsObj.setMmsResponse(responseObj);
        return mmsObj;
    }
}
