package com.example.M16.controller;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.config.annotation.rsocket.RSocketSecurity.JwtSpec;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.M16.models.Usuari;
import com.example.M16.models.UsuariAutentificacio;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;

@RestController
public class UserController {
	@PostMapping("user")
	public UsuariAutentificacio login (@RequestParam("user") String user,
			@RequestParam("pwd") String pwd){
		String token = getJWTToken(user); 
		UsuariAutentificacio usuari = new UsuariAutentificacio(); 
		usuari.setName(user);
		usuari.setToken(token);
		return usuari;
	}


private String getJWTToken(String user) {
	String secretKey ="clauSecreta";
	List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
	
	String token = Jwts
			.builder()
			.setId("softtekJWT").setSubject(user)
			.claim("authorities", grantedAuthorities.stream()
													.map(GrantedAuthority::getAuthority)
													.collect(Collectors.toList()))
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis()+600000))
			.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
	
	return "Bearer " + token; 
}

}