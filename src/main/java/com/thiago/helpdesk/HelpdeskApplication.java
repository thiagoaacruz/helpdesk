package com.thiago.helpdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelpdeskApplication {
//implements CommandLineRunner esse comando tem um método "run" que irá rodar, sempre que startar aplicação

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

}
