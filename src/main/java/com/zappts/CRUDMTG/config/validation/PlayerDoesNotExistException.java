package com.zappts.CRUDMTG.config.validation;

public class PlayerDoesNotExistException extends RuntimeException{
	  
	public PlayerDoesNotExistException(Long idplayer){
		    super("Jogador " + idplayer + " não existe!");
		  }

}
