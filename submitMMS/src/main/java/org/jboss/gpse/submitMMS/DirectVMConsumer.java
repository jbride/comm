package org.jboss.gpse.submitMMS;


import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import org.apache.log4j.Logger;

import org.jboss.gpse.MMS;
import org.jboss.gpse.MMSResponse;

@Singleton
public class DirectVMConsumer {

    private static Logger log = Logger.getLogger("DirectVMConsumer");
    
    public DirectVMConsumer(){
    	
    }

    @PostConstruct
    public void initializeDirectVMConsumer() {
    	log.info("initializeDirectVMConsumer() ... start");
    }
}
