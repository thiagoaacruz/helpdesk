package com.thiago.helpdesk.domain.enums;

public enum Status {
	
	//Criando a classe de usuarios do meu sistema
	ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO"); 
	
	private Integer codigo;
	private String descricao;
	
	
	
	//Construtor personalizado
	private Status(Integer codigo, String descricao) {
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
	
	public static Status toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		//nesse for ele retorna o status que foi selecionado, no meu caso tenho (0 , 1 , 2)
		for(Status x : Status.values()) {
			
			if(cod.equals(x.getCodigo())) {
				return x;
			}
			
		}
		//Caso for um status que não condiz, tenho esse retorno de status inválido
		throw new IllegalArgumentException("Status inválido");
		
		
		
	}
	
	
	
	
	
	
	

}
