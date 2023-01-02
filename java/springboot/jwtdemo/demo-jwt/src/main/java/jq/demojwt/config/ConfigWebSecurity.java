package jq.demojwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigWebSecurity {

	@Bean
	public InMemoryUserDetailsManager users() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("jorge").password("123456").roles("USER").build();

		UserDetails admin = User.withDefaultPasswordEncoder()
				.username("admin").password("adm123").roles("ADMIN")
				.build();

		UserDetails master = User.withDefaultPasswordEncoder()
				.username("master").password("master")
				.roles("ADMIN", "USER").build();

		return new InMemoryUserDetailsManager(user,admin,master);
	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable()).authorizeRequests(auth -> {
			auth.antMatchers("/api/v1/hello").permitAll();
			auth.antMatchers("/api/v1/user").hasAnyRole("USER");
			auth.antMatchers("/api/v1/admin").hasAnyRole("ADMIN");
		}).httpBasic(Customizer.withDefaults()).build();
//		return http
//		.csrf().disable().authorizeRequests()
//		.antMatchers("/api/v1/hello").permitAll()
//		.anyRequest().authenticated().and().httpBasic().and().build();
	}
}
