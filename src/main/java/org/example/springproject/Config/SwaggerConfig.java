package org.example.springproject.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Gestion Championnat")
                        .version("1.0.0")
                        .description("Documentation de l'API REST " +
                                "pour la gestion du championnat automobile")
                        .contact(new Contact()
                                .name("Haifa Cheikh")
                                .email("haifa@esprit.tn"))
                        .license(new License()
                                .name("ESPRIT 2026"))
                );
    }
}