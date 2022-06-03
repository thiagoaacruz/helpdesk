package com.thiago.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.thiago.helpdesk.domain.enums.Perfil;

@Entity
public class Cliente extends Pessoa {
	
	private static final long serialVersionUID = 1L;// Esse comando faz referência ao extends 

	@OneToMany(mappedBy = "cliente") //Nesse comando crio a referência com a classe "Chamado", que tem o comando  @JoinColumn(name = "cliente_id")
	private List<Chamado> chamados =  new ArrayList<>();//criando uma lista de chamados

	//construtor padrão da super classe
	public Cliente() {
		super();
		addPerfil(Perfil.CLIENTE);//Com esse comando todo item inserido será no minimo cliente.
	
	}

	
	//Construtor personalizado da super classe, erdando os atributos de pessoa 
	public Cliente(Integer id, String nome, String cpf, String email, String senha) {
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
