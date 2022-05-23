package com.zappts.CRUDMTG.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Player {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idplayer;
	private String nameplayer;
	
	public Player() {
	}
	
	public Player(String nameplayer) {

		this.nameplayer = nameplayer;
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

	
}
