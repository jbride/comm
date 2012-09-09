package org.jboss.gpse.submitSMS;

import java.util.Properties;
import java.util.Map;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.Context;

public class SimpleProducer {

    private static final String PROPERTIES_FILE_NAME = "/messaging.properties";
    private static final String CONNECTION_FACTORY_NAME = "connectionfactory";
    private static final String QUEUE_URL_PATH = "queueUrlPath";
    private static final String TEXT = "org.jboss.gpse.submitSMS.text";
    private static final String CPID = "org.jboss.gpse.submitSMS.cpid";

    
    public static void main(String args[]) {

        Properties properties = new Properties();

        Context jmsProviderContext = null;
        Connection connObj = null;
        Session sessionObj = null;
        try {
            properties.load(SimpleProducer.class.getResourceAsStream(PROPERTIES_FILE_NAME));
            if(properties.size() == 0)
                throw new RuntimeException("start() no properties defined in "+PROPERTIES_FILE_NAME);

            StringBuilder sBuilder  = new StringBuilder();
            for (Map.Entry<?, ?> entry: properties.entrySet()) {
                sBuilder.append("\n\t");
                sBuilder.append(entry.getKey());
                sBuilder.append(" = ");
                sBuilder.append(entry.getValue());
            }
            System.out.println("main() properties = "+sBuilder.toString());
            jmsProviderContext = new InitialContext(properties);


            //final ConnectionFactory connectionFactory = (ConnectionFactory) jmsProviderContext.lookup(CONNECTION_FACTORY_NAME); //QPID specific
            final ConnectionFactory connectionFactory = (ConnectionFactory) jmsProviderContext.lookup((String)properties.get(CONNECTION_FACTORY_NAME));
            connObj = connectionFactory.createConnection();
            connObj.setExceptionListener(new ExceptionListener() {
                public void onException(final JMSException e) {
                    System.out.println("JMSException = "+e);
                }
            });
            sessionObj = connObj.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination simpleQueue = (Destination)jmsProviderContext.lookup((String)properties.get(QUEUE_URL_PATH));
            MessageProducer simpleProducer = sessionObj.createProducer(simpleQueue);

            SMS smsObj = new SMS();
            smsObj.setText((String)properties.get(TEXT));

            if(properties.get(CPID) != null) {
                smsObj.setCpid(Integer.parseInt((String)properties.get(CPID)));
            }
            ObjectMessage oMessage = sessionObj.createObjectMessage();
            oMessage.setObject(smsObj);
            simpleProducer.send(oMessage);

        } catch(Exception x) {
            throw new RuntimeException(x);
        } finally {
            try {
                if(jmsProviderContext != null)
                    jmsProviderContext.close();
                if(sessionObj != null)
                    sessionObj.close();
                if(connObj != null)
                    connObj.close();
            } catch(Exception x) {
                x.printStackTrace();
            }
        }
    }
}

