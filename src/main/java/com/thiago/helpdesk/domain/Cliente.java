package com.thiago.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
	
	private List<Chamado> chamados =  new ArrayList<>();//criando uma lista de chamados

	
	
	//construtor padrão da super classe
	public Cliente() {
		super();
	
	}

	
	//Construtor personalizado da super classe, erdando os atributos de pessoa 
	public Cliente(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
	
	}

	
	
	
	//getters e setters da lista de chamados
	public List<Chamado> getChamados() {
		return chamados;
	}


	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
	
	
	
	
	
	
	
	
	

}
