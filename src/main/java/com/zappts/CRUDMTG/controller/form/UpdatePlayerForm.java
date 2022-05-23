package com.zappts.CRUDMTG.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.zappts.CRUDMTG.model.Player;
import com.zappts.CRUDMTG.repository.PlayerRepository;

public class UpdatePlayerForm {

	@NotNull @NotEmpty
	private String nameplayer;

	public String getNameplayer() {
		return nameplayer;
	}
	
	public Player update(Long idplayer, PlayerRepository playerRepository) {
		///exemplo para montar edição de listas
		Player player = playerRepository.getById(idplayer);
		player.setNameplayer(this.nameplayer);

		return player;
	}
	
	
	
}
