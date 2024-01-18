package org.app.fizzbuzzapp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(servers = @Server(url = "http://localhost:8080"),
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "FizzBuzz",
                description = "This is a sample FizzBuzz server"
        ))
@Configuration
public class SpringDocConfiguration {
}
