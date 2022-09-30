package com.zappts.CRUDMTG.config.validation;

public class PlayerDoesNotExistException extends RuntimeException{
	  
	public PlayerDoesNotExistException(Integer idplayer){
		    super("Jogador " + idplayer + " não existe!");
		  }

}
