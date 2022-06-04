package com.thiago.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiago.helpdesk.domain.Pessoa;

//criando as inferfaces para salvar os dados no banco
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
	

}
