package com.thiago.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiago.helpdesk.domain.Chamado;

//criando as inferfaces para salvar os dados no banco

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{
	
	

}
