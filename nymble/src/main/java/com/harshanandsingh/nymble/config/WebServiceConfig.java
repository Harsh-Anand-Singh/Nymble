package com.harshanandsingh.nymble.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "activities")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema activitiesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ActivitiesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://harshanandsingh.com/nymble");
        wsdl11Definition.setSchema(activitiesSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema activitiesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("activities.xsd"));
    }
    @Bean(name = "destinations")
    public DefaultWsdl11Definition destinationWsdl11Definition(XsdSchema destinationsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("DestinationsPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://harshanandsingh.com/nymble");
        wsdl11Definition.setSchema(destinationsSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema destinationsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("destinations.xsd"));
    }
}