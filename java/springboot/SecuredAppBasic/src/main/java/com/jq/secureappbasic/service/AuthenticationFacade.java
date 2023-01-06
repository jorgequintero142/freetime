package com.jq.secureappbasic.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {

	@Override
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	@Override
	public String getNameFromAuth() {
		Authentication auth = getAuthentication();
		if (auth != null && !auth.getName().equals("anonymousUser")) {
			return auth.getName();
		}
		return null;
	}

}