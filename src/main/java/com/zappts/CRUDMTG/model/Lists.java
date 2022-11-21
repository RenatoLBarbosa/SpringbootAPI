package com.zappts.CRUDMTG.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Lists {
	
	@Id
	@GeneratedValue
	@Column(name="idlist")
	private Long idlist;
	
	@Column(name="namelist")
	private String namelist;
	
	@ManyToOne
	@JoinColumn(name = "idplayer")
	@JsonIgnore
	@JsonManagedReference
	private Player player;
	
	@Column(name="pricelist")
	private double pricelist;
	
	@OneToMany(mappedBy = "lists", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
    private List<CardList> cardlist;
	
	public Lists() {
		this.cardlist = new ArrayList<>();
	}
	
	public Lists(String namelist, Player player, double pricelist) {
		this.namelist = namelist;
		this.player = player;
		this.pricelist = pricelist;
		this.cardlist = new ArrayList<>();
	}
	
	public String getNamelist() {
		return namelist;
	}
	public void setNamelist(String namelist) {
		this.namelist = namelist;
	}
	public Long getIdlist() {
		return idlist;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public double getPricelist() {
		return pricelist;
	}
	public void setPricelist(double pricelist) {
		this.pricelist = pricelist;
	}
	public List<CardList> getCardlist() {
		return cardlist;
	}
	public void setCardlist(List<CardList> cardlist) {
		this.cardlist = cardlist;
	}
		
}
