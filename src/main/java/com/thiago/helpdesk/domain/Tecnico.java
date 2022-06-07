package com.thiago.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thiago.helpdesk.domain.enums.Perfil;


@Entity
public class Tecnico extends Pessoa {
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore //esse comando irá ignorar a busca pelo chamado
	@OneToMany(mappedBy = "tecnico")//Nesse comando crio a referência com a classe "Chamado", que tem o comando  @JoinColumn(name = "tecnico_id")
	private List<Chamado> chamados =  new ArrayList<>();//Esse comando faz referência ao extends 

	
	
	
	//construtor padrão da super classe
	public Tecnico() {
		super();
		addPerfil(Perfil.CLIENTE);//Com esse comando todo item inserido será no minimo cliente.
		
	}

	
	//Construtor personalizado da super classe, erdando os atributos de pessoa 
	public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.CLIENTE);//Com esse comando todo item inserido será no minimo cliente.
		
	}

	
	
	
	//getters e setters da lista de chamados

	public List<Chamado> getChamados() {
		return chamados;
	}


	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



