package com.zappts.CRUDMTG.dto.player;

import java.util.List;
import java.util.stream.Collectors;

import com.zappts.CRUDMTG.model.Player;

public class PlayerDto {

	private Long idplayer;
	private String username;
	private String pwd;

	public PlayerDto(Player player) {
		this.idplayer = player.getIdplayer();
		this.username = player.getUsername();
		this.username = player.getPwd();

	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getIdplayer() {
		return idplayer;
	}

	public static List<PlayerDto> converter(List<Player> player) {
		return player.stream().map(PlayerDto::new).collect(Collectors.toList());

	}

}
