package com.zappts.CRUDMTG.form.player;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.zappts.CRUDMTG.model.Player;
import com.zappts.CRUDMTG.repository.PlayerRepository;


public class PlayerForm {

	@NotNull @NotEmpty
	private String username;
	@NotNull @NotEmpty
	private String pwd;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Player converter(PlayerRepository playerRepository) {

		return new Player(username,pwd);
	}
	
	
}
