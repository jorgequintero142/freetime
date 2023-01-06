package com.jq.secureappbasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfigWeb {

	@Bean
	public InMemoryUserDetailsManager users() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("jorge")
				.password("123456")
				.roles("USER").build();

		UserDetails admin = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("adm123")
				.roles("ADMIN")
				.build();

		UserDetails master = User.withDefaultPasswordEncoder()
				.username("master")
				.password("master")
				.roles("ADMIN", "USER")
				.build();

		return new InMemoryUserDetailsManager(user, admin, master);
	}

	@Bean
	public SecurityFilterChain setup(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeRequests(auth -> {
			auth.antMatchers(HttpMethod.GET, "/api/v1/humanspecie/*").permitAll();
			auth.antMatchers("/home", "/login").permitAll();
			auth.antMatchers("/human/*").authenticated();

		}).formLogin(form -> {
			form.loginPage("/login");
		})
		.logout().logoutSuccessUrl("/login").and()		
		.build();
	}
}
