package org.jboss.gpse.submitSMS;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sms")
public class SMS implements Serializable {
    @XmlElement(required = true)
    private int cpid;
    
    @XmlElement(required = true)
    private int sender;
    
    @XmlElement(required = true)
    private String senderS;
    
    @XmlElement(required = true)
    private List<String> recipients = new ArrayList<String>();
    
    @XmlElement(required = true)
    private String text;

    private SMSResponse smsResponse = null;
    private String destination;

    public String toString() {
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("\ncpid = "+cpid);
        sBuffer.append("\nsender = "+sender);
        sBuffer.append("\nsenderS = "+senderS);
        sBuffer.append("\ntext = "+text);
        for(String recipient : recipients) {
            sBuffer.append("\n\trecipient = "+recipient);
        }
        return sBuffer.toString();
    }

    public SMSResponse getSmsResponse() {
        return smsResponse;
    }
    public void setSmsResponse(SMSResponse x) {
        smsResponse = x;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String x) {
        this.destination = x;
    }
    
    public int getCpid() {
        return cpid;
    }
    public void setCpid(int cpid) {
        this.cpid = cpid;
    }
    public int getSender() {
        return sender;
    }
    public void setSender(int sender) {
        this.sender = sender;
    }
    public String getSenderS() {
        return senderS;
    }
    public void setSenderS(String senderS) {
        this.senderS = senderS;
    }
    public List<String> getRecipients() {
        return recipients;
    }
    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
