package edu.fatec.RevisaoAutomotiva.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("edu.fatec.RevisaoAutomotiva.rest.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("API Revisão de automóvel")
                .version("1.0")
                .description("API criada para o projeto de Engenharia de Software III do 4º Semestre de ADS 2021-2 da FATEC São José dos Campos - Prof. Jessen Vidal")
                .contact(contact())
                .build();
    }

    private Contact contact(){
        return new Contact(
            "Nicholas Roque",
            "https://github.com/NicholasRoque",
            "nicholas.sroque@gmail.com"
        );
    }

}