package com.thiago.helpdesk.domain;

import java.time.LocalDate;

import com.thiago.helpdesk.domain.enums.Prioridade;
import com.thiago.helpdesk.domain.enums.Status;

public class Chamado {
	private Integer id;
	private LocalDate dataAbertura = LocalDate.now(); //LocalDate.now(); = (Comando para criar a data atual)
	private LocalDate dataFechamento;
	private Prioridade prioridade; //Criando vínculo com a classe "Prioridade"
	private Status status; //Criando vínculo com a classe "Status"
	private String titulo;
	private String observacoes;
	
	private Tecnico tecnico; //instanciando a classe Tecnico
	private Cliente	cliente; //instanciando a classe Cliente
	
	
}
