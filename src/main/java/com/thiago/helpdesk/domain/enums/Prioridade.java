package com.thiago.helpdesk.domain.enums;

public enum Prioridade {
	
	//Criando a classe de usuarios do meu sistema
	BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA"); 
	
	private Integer codigo;
	private String descricao;
	
	
	
	//Construtor personalizado
	private Prioridade(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	
	
	//getter
	public Integer getCodigo() {
		return codigo;
	}



	public String getDescricao() {
		return descricao;
	}
	
	
	//Método de verificação
	
	public static Prioridade toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		//nesse for ele retorna a prioridade que foi selecionado, no meu caso tenho (0 , 1 , 2)
		for(Prioridade x : Prioridade.values()) {
			
			if(cod.equals(x.getCodigo())) {
				return x;
			}
			
		}
		//Caso for uma prioridade que não condiz, tenho esse retorno de prioridade inválida
		throw new IllegalArgumentException("Prioridade inválida");
		
		
		
	}
	
	
	
	
	
	
	

}
