package jq.demojwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jq.demojwt.service.TokenService;

@RestController
public class AuthController {

	@Autowired
	TokenService tokenService;

	@PostMapping("/token")
	public String getToken(Authentication authentication) {
		return tokenService.generateToken(authentication);
	}
}