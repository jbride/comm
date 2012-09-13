package org.jboss.gpse.submitMMS;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.Logger;

import org.jboss.gpse.MMS;
import org.jboss.gpse.MMSResponse;

@ApplicationScoped
@Startup
@Singleton
public class DirectVMConsumer {

    private static Logger log = Logger.getLogger("DirectVMConsumer");

    private CamelContext camelContext = null;
    
    public DirectVMConsumer(){
    	log.info("DirectVMConsumer() ... constructor");
    }

    @PostConstruct
    public void initializeDirectVMConsumer() {
    	log.info("initializeDirectVMConsumer() ... start");
        try {
            camelContext = new DefaultCamelContext();
            camelContext.addRoutes(new RouteBuilder() {
                public void configure(){
                    from("direct-vm:directVMTest")
                    .process(new Processor() {
                        public void process(Exchange exchange) throws Exception {
                            log.info("process exchange = "+exchange);
                            MMS mmsObj = (MMS)exchange.getOut().getBody();
                            MMSResponse responseObj = new MMSResponse();
                            responseObj.setCpid(mmsObj.getCpid());
                            mmsObj.setMmsResponse(responseObj);
                        }
                    })
                    //.to("file://tmp/output.txt");
                    ;
                }
            });
            
            camelContext.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void destroy() {
        try {
            if(camelContext != null)
                camelContext.stop();
        } catch(Exception x) {
            x.printStackTrace();
        }
    }
}
