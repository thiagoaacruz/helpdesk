package com.thiago.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.helpdesk.domain.Tecnico;
import com.thiago.helpdesk.repositories.TecnicoRepository;
import com.thiago.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	
	
	public Tecnico findById(Integer id) {
		
		Optional<Tecnico> obj = repository.findById(id);//
		
		//esse comando é um exceção para um objeto não encontrado!!!
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! id: " + id));
	}


	//método vinculado a classe TecnicoResource
	public List<Tecnico> findAll() {
		
		return repository.findAll();
	}

}
