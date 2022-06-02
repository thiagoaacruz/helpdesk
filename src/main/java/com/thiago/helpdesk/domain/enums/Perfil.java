package com.thiago.helpdesk.domain.enums;

public enum Perfil {
	
	//Criando a classe de usuarios do meu sistema
	ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE"), TECNICO(2, "ROLE_TECNICO"); 
	
	private Integer codigo;
	private String descricao;
	
	
	
	//Construtor personalizado
	private Perfil(Integer codigo, String descricao) {
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
	
	public static Perfil toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		//nesse for ele retorna o perfil que foi selecionado, no meu caso tenho (0 , 1 , 2)
		for(Perfil x : Perfil.values()) {
			
			if(cod.equals(x.getCodigo())) {
				return x;
			}
			
		}
		//Caso for um perfil que não condiz, tenho esse retorno de perfil inválido
		throw new IllegalArgumentException("Perfil inválido");
		
		
		
	}
	
	
	
	
	
	
	

}
