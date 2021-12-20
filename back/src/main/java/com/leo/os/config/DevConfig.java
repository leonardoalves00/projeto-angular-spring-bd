package com.leo.os.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.leo.os.services.BDService;

@Configuration
@Profile("test")
public class DevConfig {
	
	@Autowired
	private BDService bdService;
	
	@Bean
	public void instanciaBD() {
		this.bdService.instanciaDB();
	}

}
