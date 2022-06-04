package com.thiago.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiago.helpdesk.domain.Cliente;

//criando as inferfaces para salvar os dados no banco

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	

}
