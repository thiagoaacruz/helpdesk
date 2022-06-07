package com.thiago.helpdesk.services.exceptions;


	//Esse classe foi criada extendendo a RuntimeException, para podermos manipular os erros
public class ObjectnotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	//Peguei os dois construtores para poder manipular, sendo o primeiro com a informação da messagem e da causa.
	public ObjectnotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ObjectnotFoundException(String message) {
		super(message);
		
	}
	
	
	
	
	

}
