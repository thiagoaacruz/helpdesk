package com.thiago.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.helpdesk.domain.Chamado;
import com.thiago.helpdesk.domain.Cliente;
import com.thiago.helpdesk.domain.Tecnico;
import com.thiago.helpdesk.domain.enums.Perfil;
import com.thiago.helpdesk.domain.enums.Prioridade;
import com.thiago.helpdesk.domain.enums.Status;
import com.thiago.helpdesk.repositories.ChamadoRepository;
import com.thiago.helpdesk.repositories.ClienteRepository;
import com.thiago.helpdesk.repositories.TecnicoRepository;

@Service //Tem essa notação porque é uma classe de "serviço"
public class DBService {
	
	@Autowired //Criando injeção de dependência, para pode gravar no banco de dados, criando vícunlo com os repositores
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	
	//Método com as instancias, para quando for chamado ele irá salvar as informações contida nela no banco de dados 
	public void instanciaDB(){
		
		Tecnico tec1 = new Tecnico(null, "Thiago Augusto", "111111111111", "thiago@email.com", "123");
		tec1.addPerfil(Perfil.ADMIN);//atribuindo o perfil de ADMIN
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "222222222222", "torvalds@mail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		
		
		tecnicoRepository.saveAll(Arrays.asList(tec1)); //salvando no banco de dados, a instância "tecnicoRepository"
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
