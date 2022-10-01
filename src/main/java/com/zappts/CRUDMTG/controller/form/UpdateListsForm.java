package com.zappts.CRUDMTG.controller.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.zappts.CRUDMTG.model.Card;
import com.zappts.CRUDMTG.model.Lists;
import com.zappts.CRUDMTG.model.Player;
import com.zappts.CRUDMTG.repository.ListsRepository;

public class UpdateListsForm {

	@NotNull @NotEmpty
	private String namelist;
	@NotNull
	private int qtdcard;
	@NotNull
	private Card idcard; 
	@NotNull
	private Player idplayer;
	

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
		return idplayer;
	}
	public void setIdplayer(Player idplayer) {
		this.idplayer = idplayer;
	}
	public Card getIdcard() {
		return idcard;
	}
	public void setIdcard(Card idcard) {
		this.idcard = idcard;
	}
	
	
	public Lists update(Integer idlist, ListsRepository listsRepository) {
		Lists lists = listsRepository.getById(idlist);
		lists.setNamelist(this.namelist);
		lists.setQtdcard(this.qtdcard);
		lists.setIdcard(idcard);
		lists.setIdplayer(idplayer);
		
		return lists;
	}
	
	
	
}
