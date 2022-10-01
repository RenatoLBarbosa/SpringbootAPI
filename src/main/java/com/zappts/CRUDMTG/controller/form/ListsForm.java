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
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	
	
	public Lists converter(ListsRepository listsRepository) {
//		System.out.println("idcard"+this.card+" idplayer "+this.player);
		return new Lists(namelist,qtdcard,card,player);
	}
	
}
