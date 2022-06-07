package com.thiago.helpdesk.resources.exceptios;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.thiago.helpdesk.services.exceptions.ObjectnotFoundException;

@ControllerAdvice 
/*@ControllerAdvice é uma especialização da anotação @Component que permite manipular
exceções em todo o aplicativo em um componente de manipulação global. Ele pode ser visto como um interceptador de
exceções lançadas por métodos anotados com @RequestMapping e similares.*/
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectnotFoundException.class) //Criando o manipiulador de exceção da classe ObjectnotFoundException
	public ResponseEntity<StandardError> objectnotFoundException(ObjectnotFoundException ex, 
			HttpServletRequest request){
		
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), 
				"Object Not Found", ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	
	

}
