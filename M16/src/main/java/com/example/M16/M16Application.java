package com.example.M16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.M16.models.Partida;
import com.example.M16.security.JWTAuthorizationFilter;

@SpringBootApplication
public class M16Application {

	public static void main(String[] args) {
		SpringApplication.run(M16Application.class, args);
		Partida partida = new Partida(); 
		System.out.println(partida.toString());
	}
	
	 @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter{
       
        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http.csrf().disable()
                 .addFilterAfter(new JWTAuthorizationFilter(), 
                		 UsernamePasswordAuthenticationFilter.class)
                 .authorizeRequests()
                 .antMatchers(HttpMethod.POST, "/user").permitAll()
                 .anyRequest().authenticated();
        }
    }
    

}
