package com.estudo.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudo.cursomc.services.DBService;

@Configuration
@Profile("test")
public class TesteConfig {

	@Autowired
	private DBService db;
	
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		db.intantiateTestDatabase();
		
		return true;
	}
	
}
