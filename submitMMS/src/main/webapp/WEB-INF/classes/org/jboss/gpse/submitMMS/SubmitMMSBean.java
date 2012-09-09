package org.jboss.gpse.submitMMS;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.Logger;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class SubmitMMSBean implements ISubmitMMS {

    private Logger log = Logger.getLogger("SubmitMMSBean");

    @WebMethod
    public void acceptMMS() {
        log.info("acceptMMS() hello ");
        CamelContext context = new DefaultCamelContext();
        try {
            context.addRoutes(new RouteBuilder() {
                public void configure(){
                    from("switchyard://IRedService");
                }
            });
            
            context.start();
            Thread.sleep(1000);
            context.stop();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
