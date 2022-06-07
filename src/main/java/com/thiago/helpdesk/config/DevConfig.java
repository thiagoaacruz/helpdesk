package com.thiago.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.thiago.helpdesk.services.DBService;

@Configuration //Tem essa notação, porque é uma classe de configuração
@Profile("dev") //O nome desse profile é o mesmo que foi inserido no "application.properties"
public class DevConfig {
	
	@Autowired
	private DBService dbservice;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")  // comando para criar o banco de dados
	private String value;
	
	
	//método para instanciar
	
	@Bean //Essa notação é para subir os dados para o banco
	public boolean instanciaDB() {
		
		if(value.equals("create")) {//Essa condição é para verificar se no "application-dev.properties" está "create", para criar todas as tabelas
			
			this.dbservice.instanciaDB();
		}
		return false;
	}
	
	
}
