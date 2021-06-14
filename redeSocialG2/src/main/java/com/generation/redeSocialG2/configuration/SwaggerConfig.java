package com.generation.redeSocialG2.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
						.basePackage("com.generation.redeSocialG2.controller"))
				.paths(PathSelectors.any())
				.build().apiInfo(metaData())
				.useDefaultResponseMessages(false)
				.globalResponses(HttpMethod.GET,responseMessageForGet());		
	}
	public static ApiInfo metaData() {
		return new ApiInfoBuilder().title("API-Projeto Integrador")
				.description("Eduquidade: Um novo conceito de aprendizado!")
				.version("1.0.0").license("Apache License Version 2.0")
				.licenseUrl("http://localhost:8080/swagger-ui/")
				.contact(contact1()).build();
	}
	
	private static Contact contact1() {
		return new Contact("Alexander Sousa, Andára Finot, Juliana Ribeiro, Lorrans Matildes Facca"
				+ " Matheus Barbosa, Renato Nakamura",
				"https://github.com/Renato-Nakamura/Projeto-integrador/",
				"renato.yukio30@hotmail.com");
	}
	
	private static List<Response> responseMessageForGet(){
		return new ArrayList<Response>() {
			private static final long serialVersionUID = 1L;
			{
				add(new ResponseBuilder().code("200").description("Sucesso!").build());
				add(new ResponseBuilder().code("401").description("Não Autorizado!").build());
				add(new ResponseBuilder().code("403").description("Proibido!").build());
				add(new ResponseBuilder().code("404").description("Não Encontrado!").build());
				add(new ResponseBuilder().code("500").description("Erro!").build());

			}
		};
	}
	

}
