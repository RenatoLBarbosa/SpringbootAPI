package com.zappts.CRUDMTG.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "player")
public class Player {

	@Id
	@GeneratedValue
	@Column(name = "idplayer")
	public Integer idplayer;

	@Column(name = "nameplayer")
	private String nameplayer;

	@OneToMany(mappedBy = "player", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Lists> lists;

	public Player() {
		this.lists = new ArrayList<>();
	}

	public Player(String nameplayer) {
		this.nameplayer = nameplayer;
		this.lists = new ArrayList<>();
	}

	public String getNameplayer() {
		return nameplayer;
	}

	public void setNameplayer(String nameplayer) {
		this.nameplayer = nameplayer;
	}

	public Integer getIdplayer() {
		return idplayer;
	}

	public List<Lists> getLists() {
		return lists;
	}

	public void setLists(List<Lists> lists) {
		this.lists = lists;
	}

}
