package org.jboss.gpse;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mms")
public class MMS implements Serializable {
    @XmlElement(required = true)
    private int cpid;
    
    private MMSResponse mmsResponse = null;

    public String toString() {
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("\ncpid = "+cpid);
        return sBuffer.toString();
    }

    public MMSResponse getMmsResponse() {
        return mmsResponse;
    }
    public void setMmsResponse(MMSResponse x) {
        mmsResponse = x;
    }
    
    public int getCpid() {
        return cpid;
    }
    public void setCpid(int cpid) {
        this.cpid = cpid;
    }
}
