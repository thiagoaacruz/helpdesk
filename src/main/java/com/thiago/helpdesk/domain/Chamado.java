package com.thiago.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thiago.helpdesk.domain.enums.Prioridade;
import com.thiago.helpdesk.domain.enums.Status;

@Entity
public class Chamado implements Serializable { //implements Serializable = (Esse comando serve para criar uma sequencia de bytes para ser trafegados em rede)
	
	private static final long serialVersionUID = 1L;// Esse comando faz referência ao (implements Serializable) {
	
	@Id //informando que o atributo é uma chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Comando que irá informar que a chave irá ser criada de forma automática, e quem irá criar será o banco de dados
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yy") //Criando o padrão da data para receber do banco de dados
	private LocalDate dataAbertura = LocalDate.now(); //LocalDate.now(); = (Comando para criar a data atual)
	
	@JsonFormat(pattern = "dd/MM/yy") //Criando o padrão da data para receber do banco de dados
	private LocalDate dataFechamento;
	
	private Prioridade prioridade; //Criando vínculo com a classe "Prioridade"
	private Status status; //Criando vínculo com a classe "Status"
	private String titulo;
	private String observacoes;
	
	
	@ManyToOne //Esse tipo de notação é muitos chamados para um tecnico
	@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico; //instanciando a classe Tecnico
	
	
	@ManyToOne //Esse tipo de notação é muitos chamados para um tecnico
	@JoinColumn(name = "cliente_id")
	private Cliente	cliente; //instanciando a classe Cliente
	
	
	public Chamado() {
		super();
		
	}
	
	
	//nesse construtor não iremos receber a data de abertura e nem de fechamento
	public Chamado(Integer id, Prioridade prioridade, Status status, String titulo, String observacoes, Tecnico tecnico,
			Cliente cliente) {
		super();
		this.id = id;
		this.prioridade = prioridade;
		this.status = status;
		this.titulo = titulo;
		this.observacoes = observacoes;
		this.tecnico = tecnico;
		this.cliente = cliente;
	}
	
	
	

	//getter e setters
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getDataAbertura() {
		return dataAbertura;
	}


	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}


	public LocalDate getDataFechamento() {
		return dataFechamento;
	}


	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}


	public Prioridade getPrioridade() {
		return prioridade;
	}


	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getObservacoes() {
		return observacoes;
	}


	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}


	public Tecnico getTecnico() {
		return tecnico;
	}


	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	
	
	
	
	//Utilizando o hasecode para poder fazer a referência pelo id
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	

	
	
	
}
