purpose:
    - provide example of typical SOA use cases implemented using JBoss Switchyard
    - provide example of application provisioning to a JBoss EAP 6.* runtime leveraging ProcessFlowProvision

details
    0)  common
        - demonstrates build and deployment of a project's domain model as static modules in a JBoss EAP 6.* runtime

    1) simpleJaxWs
        - basic JaxWS service used as target by other switchyard services in this project

    2)  submitSMS
        - demonstrates example of a SCA component promoted by the following gateway services :
            a)  a gateway service exposed via a JMS binding 
            b)  a gateway service exposed via a SOAP binding
        - provides a simple remote Hornetq producer that, when invoked, pushes a message to a queue 
            (where subsequently the JMS binding in the SY service consumes that message)
        - provides a simple JAX-WS client that, when invoked, synchronously invokes the SOAP service
        - demonstrates example of rules based validation service
        - demonstrates example of rules based content based routing service

    3)  submitMMS
        - demonstrates example of a SCA component promoted via a camel 'direct-vm' route
        - local functionality that invokes this SCA component via camel's 'direct-vm' route include :
            a)  a JAX-RS service
            b)  a JAX-WS service

    4)  gwReferences
        - demonstrates examples of invoking the following remote gateway references :

