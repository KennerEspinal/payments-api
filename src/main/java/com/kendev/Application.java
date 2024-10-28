package com.kendev;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(
        info = @Info(
                title = "Payment Service API",
                version = "1.0",
                description = "API Documentation for Payment Service",
                license = @License(name = "Apache 2.0"),
                contact = @Contact(
                        name = "Support",
                        email = "kennerespinalg@gmail.com"
                )
        ),
        servers = {
                @Server(url = "http://localhost:8080")
        }
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}