package com.hibernate.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
public class AppConfig {
	
	@Value("${jdbc.driver.name}")
	private String jdbcDriverClass;
	

	@Value("${jdbc.url}")
	private String url;
	

	@Value("${jdbc.username}")
	private String username;
	

	@Value("${jdbc.password}")
	private String password;
	

	@Value("${hibernate.dialect}")
	private String dialect;
	

	@Value("${hibernate.show.sql}")
	private Boolean showSQL;
	
	@Value("${hibernate.format.sql}")
	private Boolean formatSQL;
}
