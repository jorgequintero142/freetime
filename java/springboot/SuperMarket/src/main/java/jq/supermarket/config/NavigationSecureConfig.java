package jq.supermarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class NavigationSecureConfig {

	@SuppressWarnings("deprecation")
	@Bean
	public InMemoryUserDetailsManager users() {
		UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("adm123").roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(admin);
	}

	@SuppressWarnings("deprecation")
	@Bean
	public SecurityFilterChain setup(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeRequests(auth -> {
			auth.requestMatchers(HttpMethod.GET, "/").permitAll();
			auth.requestMatchers("/home", "/login").permitAll();
			auth.requestMatchers("/admin/product/*").hasRole("ADMIN");

		}).formLogin(form -> {
			form.loginPage("/login");
		})
				/*
				 * .formLogin(form -> { form.loginPage("/login");
				 * }).logout().logoutSuccessUrl("/login").and()
				 */
				.build();
	}
}
