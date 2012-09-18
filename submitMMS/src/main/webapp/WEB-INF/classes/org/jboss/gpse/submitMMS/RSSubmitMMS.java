package org.jboss.gpse.submitMMS;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.Logger;

import org.jboss.gpse.MMS;

@Path("/")
public class RSSubmitMMS implements IJaxSubmitMMS {

    public static final String DIRECT_VM_URL = "org.jboss.gpse.submitMMS.direct.vm.url";
    private static Logger log = Logger.getLogger("RSSubmitMMS");

    private String directVMUrl = "direct-vm:submitMMSComponentFromDirectVM";

    public RSSubmitMMS() {
        if(System.getProperty(DIRECT_VM_URL) != null)
            directVMUrl = System.getProperty(DIRECT_VM_URL);            
        log.info("RSSubmitMMS() using directVMUrl =  "+directVMUrl);
    }

    
    /*
     * example:    curl $HOSTNAME:8080/submitMMS/proxyMMSRequest/12345
     */
    @GET
    @Path("/proxyMMSRequest/{cpid}")
    public void proxyMMSRequest(@PathParam("cpid") final int cpid) {
        log.info("proxyMMSRequest() cpid =  "+cpid);
        CamelContext camelContext = new DefaultCamelContext();
        MMS mmsObj = new MMS();
        mmsObj.setCpid(cpid);
        
        Endpoint endpoint = camelContext.getEndpoint(directVMUrl);
        Producer producer = null;
        try {
            producer = endpoint.createProducer();
            producer.start();
            Exchange exchange = producer.createExchange();
            exchange.getIn().setBody(mmsObj);
            producer.process(exchange);
            MMS responseObj = (MMS)exchange.getIn().getBody();
            log.info("proxyMMSReqest() responseObj = "+responseObj);
            
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
    }
}
