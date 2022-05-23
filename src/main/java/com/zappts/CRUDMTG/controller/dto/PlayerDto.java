package com.zappts.CRUDMTG.controller.dto;

import java.util.List;
import java.util.stream.Collectors;


import com.zappts.CRUDMTG.model.Player;

// para controle de qual retorno quero realizar na API
public class PlayerDto {

	private Long idplayer;
	private String nameplayer;
	
	public PlayerDto(Player player) {
		this.idplayer = player.getIdplayer();
		this.nameplayer = player.getNameplayer();
		
	}
	

	public String getNameplayer() {
		return nameplayer;
	}

	public void setNameplayer(String nameplayer) {
		this.nameplayer = nameplayer;
	}

	public Long getIdplayer() {
		return idplayer;
	}

	public static List<PlayerDto> converter(List<Player> player){
		return player.stream().map(PlayerDto::new).collect(Collectors.toList());
		
	}
	
}
