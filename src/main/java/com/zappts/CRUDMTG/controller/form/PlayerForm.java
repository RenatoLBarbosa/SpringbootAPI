package com.zappts.CRUDMTG.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.zappts.CRUDMTG.model.Player;
import com.zappts.CRUDMTG.repository.PlayerRepository;


public class PlayerForm {

	@NotNull @NotEmpty
	private String nameplayer;

	public String getNameplayer() {
		return nameplayer;
	}

	public void setNameplayer(String nameplayer) {
		this.nameplayer = nameplayer;
	}

	public Player converter(PlayerRepository playerRepository) {

		return new Player(nameplayer);
	}
	
	
}
