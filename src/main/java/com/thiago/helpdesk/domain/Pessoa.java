package com.thiago.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.thiago.helpdesk.domain.enums.Perfil;


@Entity //criando uma tabela no banco de dados, nesse caso a tabela irá com o nome da classe, porque não atribuí um nome especifico
public abstract class Pessoa implements Serializable { //implements Serializable = (Esse comando serve para criar uma sequencia de bytes para ser trafegados em rede)
	
	private static final long serialVersionUID = 1L;// Esse comando faz referência ao (implements Serializable) 
	
	@Id //informando que o atributo é uma chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)// Comando que irá informar que a chave irá ser criada de forma automática, e quem irá criar será o banco de dados
	protected Integer id;
	protected String nome;
	
	@Column(unique = true)//Esse comando informa que a coluna cpf será única no banco de dados
	protected String cpf;
	
	@Column(unique = true)//Esse comando informa que a coluna email será única no banco de dados
	protected String email;
	
	protected String senha;
	
	
	@ElementCollection(fetch = FetchType.EAGER)// esse comando informa que que será uma coleção do tipo Integer, e quando der um get no banco de dados essa lista irá vir com o usuário
	@CollectionTable(name = "PERFIS") //Com esse comando vai ter uma tabela no banco de dados com apenas os perfis										
	
	protected Set<Integer> perfis = new HashSet<>(); //Criando um lista para armazenamento dos perfis(porque poder ser um cliente ou um tecnico)
	//new HashSet = (Evita iniciar o ponteiro em nulo em ponteiro exception)		
	//Set = (não deixa dois valores iguais na lista, EX: não deixa dois clientes para mesma pessoa ou dois tecnicos para mesma pessoa)
	
	protected LocalDate dataCriacao = LocalDate.now();// LocalDate.now(); = (Esse comando pega o momento que a instancia foi criada)
	//LocalDate = (esse comando pega o data/mes/ano)
	
	
	
	
	public Pessoa() {
		super();
		addPerfil(Perfil.CLIENTE);//Com esse comando todo item inserido será no minimo cliente.
	}
	
	
	
	
	//construtor personalizado
	public Pessoa(Integer id, String nome, String cpf, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		addPerfil(Perfil.CLIENTE);//Com esse comando todo item inserido será no minimo cliente.
	}


	
	


	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getCpf() {
		return cpf;
	}




	public void setCpf(String cpf) {
		this.cpf = cpf;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getSenha() {
		return senha;
	}




	public void setSenha(String senha) {
		this.senha = senha;
	}




	public Set<Perfil> getPerfis() {
		
		//.stream().map(x -> Perfil.toEnum(x)) = (mapeando cada perfil x pelo método "toEnum" que foi criado na classe (Prioridade)
		
		//.collect(Collectors.toSet()) = (coletando todas informações e fazendo a conversão para uma lista do tipo "Set", a que eu criei acima )
		
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}




	public void addPerfil(Perfil perfil) { 
		this.perfis.add(perfil.getCodigo());//this.perfis.add(perfil.getCodigo()); = (adicionando os dados na lista)
	}




	public LocalDate getDataCriacao() {
		return dataCriacao;
	}




	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}




	//hash code equals faz comparação de objetos pelo valor do seu atriubuto
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	
	
	
}
