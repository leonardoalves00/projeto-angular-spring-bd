package com.leo.os.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.leo.os.services.BDService;

@Configuration
@Profile("dev")
public class TesteConfig {
	
	@Autowired
	private BDService bdService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;
	
	@Bean
	public boolean instanciaBD() {
		if(ddl.equals("create")) {
			this.bdService.instanciaDB();
		}
		return false;
	}

}
