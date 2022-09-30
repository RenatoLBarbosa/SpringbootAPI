package com.zappts.CRUDMTG.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zappts.CRUDMTG.model.Card;
import com.zappts.CRUDMTG.model.Lists;
import com.zappts.CRUDMTG.model.Player;
import com.zappts.CRUDMTG.repository.ListsRepository;


public class ListsForm {

	@NotNull @NotEmpty
	private String namelist;
	@NotNull 
	private int qtdcard;
	@NotNull
	private Card card; 
	@NotNull 
	private Player player;
	@NotNull
	private Double pricecard;
	

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
	public Player getIdplayer() {
		return player;
	}
	public void setIdplayer(Player idplayer) {
		this.player = idplayer;
	}
	public Card getIdcard() {
		return card;
	}
	public Double getPricecard() {
		return pricecard;
	}
	public void setPricecard(Double pricecard) {
		this.pricecard = pricecard;
	}
	
	
	public Lists converter(ListsRepository listsRepository) {
//		System.out.println("idcard"+getIdcard()+" idplayer "+getIdplayer());
//		new ObjectMapper().readValue(json, Item.class);
		return new Lists(namelist,qtdcard,card,player, pricecard);
	}
	
}
