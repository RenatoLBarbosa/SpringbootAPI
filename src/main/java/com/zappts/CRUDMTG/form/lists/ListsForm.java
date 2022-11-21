package com.zappts.CRUDMTG.form.lists;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.zappts.CRUDMTG.model.Lists;
import com.zappts.CRUDMTG.model.Player;
import com.zappts.CRUDMTG.repository.ListsRepository;


public class ListsForm {

	@NotNull @NotEmpty
	private String namelist;
	@NotNull @NotEmpty
	private Player player;
	@NotNull @NotEmpty
	private double pricelist;

	public String getNamelist() {
		return namelist;
	}
	public void setNamelist(String namelist) {
		this.namelist = namelist;
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
	
	public Lists converter(ListsRepository listsRepository) {
		return new Lists(namelist,player,pricelist);
	}
	
}
