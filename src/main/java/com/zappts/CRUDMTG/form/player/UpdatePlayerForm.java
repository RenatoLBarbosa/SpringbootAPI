package com.zappts.CRUDMTG.form.player;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.zappts.CRUDMTG.model.Player;
import com.zappts.CRUDMTG.repository.PlayerRepository;

public class UpdatePlayerForm {

	@NotNull @NotEmpty
	private String username;
	@NotNull @NotEmpty
	private String pwd;

	public String getUsername() {
		return username;
	}
	public String getPwd() {
		return pwd;
	}
	
	public Player update(Long idplayer, PlayerRepository playerRepository) {
		///exemplo para montar edição de listas
		Player player = playerRepository.getById(idplayer);
		player.setUsername(this.username);
		player.setPwd(this.pwd);

		return player;
	}
	
	
	
}
