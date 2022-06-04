package com.thiago.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiago.helpdesk.domain.Tecnico;

//criando as inferfaces para salvar os dados no banco
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{
	
	

}
