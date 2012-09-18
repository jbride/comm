package org.jboss.gpse;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "smsResponse", propOrder = {
    "cpid",
    "sender",
    "errorCode"
})
@XmlRootElement(name = "smsResponse")
public class SMSResponse implements Serializable {
    public static final int STATUS_GOOD = 200;
    public static final int STATUS_BAD = 500;
    
    @XmlElement(required = true)
    private int cpid;
    
    @XmlElement(required = true)
    private int sender;
    
    @XmlElement(required = true)
    private int errorCode = STATUS_GOOD;
    
    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public int getCpid() {
        return cpid;
    }
    public void setCpid(int cpid) {
        this.cpid = cpid;
    }
}
