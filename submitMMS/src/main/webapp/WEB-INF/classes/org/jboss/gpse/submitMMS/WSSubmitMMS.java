package org.jboss.gpse.submitMMS;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.Logger;

import org.jboss.gpse.MMS;

//@WebService
//@SOAPBinding(style = SOAPBinding.Style.RPC)
@Path("/")
public class WSSubmitMMS implements IWSSubmitMMS {

    public static final String DIRECT_VM_URL = "org.jboss.gpse.submitMMS.direct.vm.url";
    private static Logger log = Logger.getLogger("WSSubmitMMS");

    private String directVMUrl = "direct-vm:submitMMSComponentFromDirectVM";

    public WSSubmitMMS() {
        if(System.getProperty(DIRECT_VM_URL) != null)
            directVMUrl = System.getProperty(DIRECT_VM_URL);            
    }

    
    /*
     * example:    curl $HOSTNAME:8080/rht-submitMMS-war/proxyMMSRequest
     */
    //@WebMethod
    @GET
    @Path("/proxyMMSRequest")
    public void proxyMMSRequest() {
        log.info("proxyMMSRequest() using directVMUrl =  "+directVMUrl);
        CamelContext camelContext = new DefaultCamelContext();
        MMS mmsObj = new MMS();
        mmsObj.setCpid(1);
        
        Endpoint endpoint = camelContext.getEndpoint(directVMUrl);
        Producer producer = null;
        try {
            producer = endpoint.createProducer();
            producer.start();
            Exchange exchange = producer.createExchange();
            exchange.getIn().setBody(mmsObj);
            producer.process(exchange);
            MMS responseObj = (MMS)exchange.getOut().getBody();
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
