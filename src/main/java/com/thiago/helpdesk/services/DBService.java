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
		Tecnico tec2 = new Tecnico(null, "Manuella Andrade", "22222222222", "Manuella@email.com", "123");
		Tecnico tec3 = new Tecnico(null, "Thais Cristiane", "333333333333", "Thais@email.com", "123");
		Tecnico tec4 = new Tecnico(null, "Cecilia Andrade", "444444444444", "Cecilia@email.com", "123");
		Tecnico tec5 = new Tecnico(null, "Cristiano tadeu", "555555555555", "Cristiano@email.com", "123");
		
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "6666666666666", "torvalds@mail.com", "123");
		Cliente cli2 = new Cliente(null, "Marta Pires", "777777777777", "Marta@mail.com", "123");
		Cliente cli3 = new Cliente(null, "Maisa Amaral", "88888888888888", "Maisa@mail.com", "123");
		Cliente cli4 = new Cliente(null, "Wanderson irineu", "999999999999", "Wanderson@mail.com", "123");
		Cliente cli5 = new Cliente(null, "Viviane da Cruz", "10101010101010", "Viviane@mail.com", "123");
		
		
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "teste chamado 1", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 02", "teste chamado 2", tec1, cli3);
		Chamado c3 = new Chamado(null, Prioridade.MEDIA, Status.ENCERRADO, "Chamado 03", "teste chamado 3", tec2, cli4);
		Chamado c4 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 04", "teste chamado 4", tec3, cli5);
		Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 05", "teste chamado 5", tec1, cli2);
		Chamado c6 = new Chamado(null, Prioridade.ALTA, Status.ENCERRADO, "Chamado 06", "teste chamado 6", tec3, cli5);
		
		
		
		
		
		
		tecnicoRepository.saveAll(Arrays.asList(tec1)); //salvando no banco de dados, a instância "tecnicoRepository"
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
