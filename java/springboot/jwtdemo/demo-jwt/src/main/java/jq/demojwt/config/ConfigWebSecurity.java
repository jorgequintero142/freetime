package jq.demojwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
@EnableWebSecurity
public class ConfigWebSecurity {

	private final RSAKeys rsaKeys;

	public ConfigWebSecurity(RSAKeys rsaKeys) {
		this.rsaKeys = rsaKeys;
	}

	@Bean
	public InMemoryUserDetailsManager users() {
		UserDetails user = User.withDefaultPasswordEncoder().username("jorge").password("123456").roles("USER").build();

		UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("adm123").roles("ADMIN")
				.build();

		UserDetails master = User.withDefaultPasswordEncoder().username("master").password("master")
				.roles("ADMIN", "USER").build();

		return new InMemoryUserDetailsManager(user, admin, master);
	}

	@Bean
	public SecurityFilterChain setup(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable()).authorizeRequests(auth -> auth.anyRequest().authenticated())
				.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.httpBasic(Customizer.withDefaults()).build();
	}

	@Bean
	JwtDecoder getJwtDecoder() {
		return NimbusJwtDecoder.withPublicKey(rsaKeys.getPublicKey()).build();
	}

	@Bean
	JwtEncoder getJwtEncoder() {
		JWK jwk = new RSAKey.Builder(rsaKeys.getPublicKey()).privateKey(rsaKeys.getPrivateKey()).build();
		JWKSource<SecurityContext> jwtEncoder = new ImmutableJWKSet<>(new JWKSet(jwk));
		return new NimbusJwtEncoder(jwtEncoder);
	}

//	@Bean
//	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//		return http.csrf(csrf -> csrf.disable()).authorizeRequests(auth -> {
//			auth.antMatchers("/api/v1/hello").permitAll();
//			auth.antMatchers("/api/v1/user").hasAnyRole("USER");
//			auth.antMatchers("/api/v1/admin").hasAnyRole("ADMIN");
//		}).httpBasic(Customizer.withDefaults()).build();
//		return http
//		.csrf().disable().authorizeRequests()
//		.antMatchers("/api/v1/hello").permitAll()
//		.anyRequest().authenticated().and().httpBasic().and().build();
//	}
}
