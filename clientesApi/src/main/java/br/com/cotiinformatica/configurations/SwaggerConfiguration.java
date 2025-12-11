package br.com.cotiinformatica.configurations;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    
    @Bean
    public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
                        .title("API Cliente")
                        .version("v1")
        				.description("Documentação da API do projeto")
        				.description("Projeto Final - Documentacao da API Cliente")
        				.contact(new Contact()
                    	.name("Marcelo Monteiro")
        				.email("marcelo.monteiro@sgp.uerj.br")));
    }

        

    }



