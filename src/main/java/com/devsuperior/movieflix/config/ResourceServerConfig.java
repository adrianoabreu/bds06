package com.devsuperior.movieflix.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	private static final String[] PUBLIC = { "/oauth/token", "/h2-console/**" };
	
	private static final String[] VISITOR_OR_MEMBER = { "/users/profile/**", 
									"/movies/**", "/genres/**" };
	
	private static final String[] REVIEW_VISITOR_OR_MEMBER  = { "/review/**" };
	
	@Autowired
	private JwtTokenStore tokenStore;
	
	@Autowired
	private Environment env;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		if(Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}
		
		http.authorizeRequests()
		.antMatchers(PUBLIC).permitAll()
		.antMatchers(HttpMethod.GET, VISITOR_OR_MEMBER ).hasAnyRole("VISITOR", "MEMBER")
		.antMatchers(HttpMethod.POST, REVIEW_VISITOR_OR_MEMBER ).hasAnyRole("VISITOR", "MEMBER")
		.anyRequest().authenticated();
	}
}
