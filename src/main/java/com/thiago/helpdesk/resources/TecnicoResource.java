package com.thiago.helpdesk.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.helpdesk.domain.Tecnico;
import com.thiago.helpdesk.domain.dtos.TecnicoDTO;
import com.thiago.helpdesk.services.TecnicoService;

@RestController //Essa notação é porque essa classe é de controle
@RequestMapping(value = "/tecnicos")   	//Essa classe é para adiconar o endpoint inicial
public class TecnicoResource {
	
	//localhost:8080/tecnicos/1  = como pesquisar no poostman
	
	@Autowired
	private TecnicoService service;
	
	
	//buscando pelo id
	@GetMapping(value = "/{id}") 
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){//sintaxe da procura
		
		Tecnico obj = service.findById(id);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));
	
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<TecnicoDTO>> findAll(){
		List<Tecnico> list = service.findAll();
		
		//Nesse comando estou fazendo ter uma lista de TecnicoDTO, para poder fazer o retorno do objeto
		List<TecnicoDTO> listDTO = list.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
		
		
	}
	
	
	
}
