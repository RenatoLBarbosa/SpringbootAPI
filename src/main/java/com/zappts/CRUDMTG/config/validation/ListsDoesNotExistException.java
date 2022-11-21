package com.zappts.CRUDMTG.config.validation;

public class ListsDoesNotExistException extends RuntimeException{
	public ListsDoesNotExistException(Long idlists){
	    super("Lista " + idlists + " não existe!");
	  }
}
