package org.jboss.gpse.gwReferences;

import javax.xml.bind.JAXBElement;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.SoapJaxbDataFormat;
import org.jboss.gpse.ObjectFactory;
import org.jboss.gpse.SMS;

public class GWRefencesRoute extends RouteBuilder {
	
	public void configure() {
		final ObjectFactory oFactory = new ObjectFactory();
		
		from("switchyard://IGWRefences")
		.log("Received message for 'IGWRefences' : ${body}")
		.to("switchyard://ISimpleJaxWs");
	}

}
