package org.jboss.gpse.submitMMS;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.Logger;

import org.jboss.gpse.MMS;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class WSSubmitMMS implements IWSSubmitMMS {

    private static Logger log = Logger.getLogger("WSSubmitMMS");

    @WebMethod
    public void proxyMMSRequest() {
        log.info("proxyMMSRequest() start ....");
        CamelContext camelContext = new DefaultCamelContext();
        MMS mmsObj = new MMS();
        
        Endpoint endpoint = camelContext.getEndpoint("direct-vm:submitMMSComponentFromDirectVM");
        Producer producer = null;
        try {
            producer = endpoint.createProducer();
            producer.start();
            Exchange exchangeToSend = producer.createExchange();
            exchangeToSend.getOut().setBody(mmsObj);
            producer.process(exchangeToSend);
        } catch(Exception x) {
            x.printStackTrace();
        } finally {
            try {
                producer.stop();
            } catch(Exception y) {
                y.printStackTrace();
            }
        }
        log.info("proxyMMSRequest() end .... ");
/*
        try {
            context.addRoutes(new RouteBuilder() {
                public void configure(){
                    from("direct:start")
                    .setBody()
                    .to("direct-vm:submitMMSComponentFromDirectVM")
                    .process(new Processor() {
                    	public void process(Exchange exchange) throws Exception {
                    		log.info("process exchange = "+exchange);
                    	}
                    });
                }
            });
            
            context.start();
            Thread.sleep(1000);
            context.stop();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
    }
}
