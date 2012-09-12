package org.jboss.gpse.submitMMS;


import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

import org.apache.log4j.Logger;

import org.jboss.gpse.MMS;
import org.jboss.gpse.MMSResponse;

@ApplicationScoped
@Startup
@Singleton
public class DirectVMConsumer {

    private static Logger log = Logger.getLogger("DirectVMConsumer");
    
    public DirectVMConsumer(){
    	log.info("DirectVMConsumer() ... constructor");
    }

    @PostConstruct
    public void initializeDirectVMConsumer() {
    	log.info("initializeDirectVMConsumer() ... start");
    }
}
