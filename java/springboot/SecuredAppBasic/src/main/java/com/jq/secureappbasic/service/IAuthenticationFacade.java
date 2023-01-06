package com.jq.secureappbasic.service;

import org.springframework.security.core.Authentication;


public interface IAuthenticationFacade {
	Authentication getAuthentication();

	String getNameFromAuth();
}
