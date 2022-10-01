package com.zappts.CRUDMTG.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Lists {
	
	@Id
	@GeneratedValue
	@Column(name="idlist")
	private Integer idlist;
	
	@Column(name="namelist")
	private String namelist;
	
	@Column(name="qtdcard")
	private int qtdcard;
	
	@ManyToOne
	@JoinColumn(name = "idcard")
	@JsonIgnore
	private Card card;
	
	@ManyToOne
	@JoinColumn(name = "idplayer")
	@JsonIgnore
	private Player player;
	
	
	public Lists() {
	}
	
	public Lists(String namelist, int qtdcard, Card idcard, Player idplayer) {
		this.namelist = namelist;
		this.qtdcard = qtdcard;
		this.card = idcard;
		this.player = idplayer;
	}
	

	public Card getIdcard() {
		return card;
	}
	public void setIdcard(Card idcard) {
		this.card = idcard;
	}
	public Player getIdplayer() {
		return player;
	}
	public void setIdplayer(Player idplayer) {
		this.player = idplayer;
	}
	public String getNamelist() {
		return namelist;
	}
	public void setNamelist(String namelist) {
		this.namelist = namelist;
	}
	public int getQtdcard() {
		return qtdcard;
	}
	public void setQtdcard(int qtdcard) {
		this.qtdcard = qtdcard;
	}
	public Integer getIdlist() {
		return idlist;
	}
		
}
