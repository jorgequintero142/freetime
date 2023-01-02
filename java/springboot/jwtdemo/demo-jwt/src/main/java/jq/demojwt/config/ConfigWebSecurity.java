package jq.demojwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ConfigWebSecurity extends WebSecurityConfigurerAdapter {

	@Override

	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable().authorizeRequests()
		.antMatchers("/api/v1/hello").permitAll()
		.anyRequest().authenticated().and().httpBasic();
	}
}
