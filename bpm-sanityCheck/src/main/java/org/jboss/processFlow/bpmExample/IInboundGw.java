package org.jboss.processFlow.bpmExample;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/")
public interface IInboundGw {
	
	/*
	 * example:   curl -X PUT -HAccept:text/plain $HOSTNAME:8080/bpm-sanityCheck/bizRuleWorkflow
	 */
	@PUT 
	@Path("bizRuleWorkflow")
	void checkBizRuleWorkflow();

}
