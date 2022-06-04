package com.thiago.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.thiago.helpdesk.services.DBService;

@Configuration //Tem essa notação, porque é uma classe de configuração
@Profile("test") //O nome desse profile é o mesmo que foi inserido no "application.properties"
public class TesteConfig {
	
	@Autowired
	private DBService dbservice;
	
	
	//método para instanciar
	
	@Bean //Essa notação é para subir os dados para o banco
	public void instanciaDB() {
		
		this.dbservice.instanciaDB();
		
		
	}
	
	
}
