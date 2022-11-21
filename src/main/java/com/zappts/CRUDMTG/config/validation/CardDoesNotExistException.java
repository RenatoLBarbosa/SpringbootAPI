package com.zappts.CRUDMTG.config.validation;

public class CardDoesNotExistException extends RuntimeException{
	  
	public CardDoesNotExistException(Long idcard){
		    super("Carta " + idcard + " não existe!");
		  }

}
