package com.generation.redeSocialG2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter
{
	//Autowired chama interfaces
	@Autowired
	private UserDetailsService userDetailsService;
	
	//Pra que serve esse override ? 
	@Override 
	protected void configure (AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService);
	}
	
	//annotation para ajudar o Spring a localizar este metodo
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception
	{
		//autorizando sessões para os caminhos informados abaixo
		http.authorizeRequests()
		.antMatchers("/usuarios/login").permitAll()
		.antMatchers("/usuarios/signin").permitAll()
		//essa linha abaixo deve pedir autorização 
		//(token) para acessar as demais funcionalidades
		.anyRequest().authenticated()
		.and().httpBasic().and().sessionManagement()
		//Essa linha abaixo indica que as sessões não serão guardadas
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		//cors habilita acesso externo de outros servidores a API
		.and().cors()
		/*
		 * When you use CSRF protection? Our recommendation 
		 * is to use CSRF protection for any request that 
		 * could be processed by a browser by normal users. 
		 * If you are only creating a service that is used by 
		 * non-browser clients, you will likely want to disable 
		 * CSRF protection.
		 */
		.and().csrf().disable();
		
	}
	
	
}
