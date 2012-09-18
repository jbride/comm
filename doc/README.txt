purpose:
    - provide example of typical SOA use cases implemented using JBoss Switchyard
    - provide example of application provisioning to a JBoss EAP 6.* runtime leveraging ProcessFlowProvision

details
    0)  domain
        - demonstrates build and deployment of a project's domain model as static modules in a JBoss EAP 6.* runtime

    1)  submitSMS
        - demonstrates example of a SCA component promoted by more than one gateway service
        - specifically, a gateway service exposed via a JMS binding and a gateway service exposed via a SOAP binding
        - provides a simple remote Hornetq producer that, when invoked, pushes a message to a queue 
            (where subsequently the JMS binding in the SY service consumes that message)
        - provides a simple JAX-WS client that, when invoked, synchronously invokes the SOAP service

    2)  submitMMS
        - demonstrates example of a SCA component promoted via a camel 'direct-vm' route
        - local functionality that invokes this SCA component via camel's 'direct-vm' route include :
            a)  a JAX-RS service
            b)  a JAX-WS service

