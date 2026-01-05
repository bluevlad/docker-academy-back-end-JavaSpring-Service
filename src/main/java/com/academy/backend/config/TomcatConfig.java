package com.academy.backend.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Value("${server.port}")
    private int serverPort;

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        // server.port is automatically handled by Spring Boot
        factory.setPort(serverPort);

        // Add additional connector for HTTP
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setPort(8080);
        factory.addAdditionalTomcatConnectors(connector);
    }
}
