package com.zappts.CRUDMTG.controller.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.zappts.CRUDMTG.model.Lists;
import com.zappts.CRUDMTG.repository.ListsRepository;

public class UpdateListsForm {

	@NotNull @NotEmpty
	private String namelist;
	@NotNull
	private int qtdcard;
	@NotNull
	private Long idcard; 
	@NotNull
	private Long idplayer;
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
	public Long getIdplayer() {
		return idplayer;
	}
	public void setIdplayer(Long idplayer) {
		this.idplayer = idplayer;
	}
	public Long getIdcard() {
		return idcard;
	}
	public void setIdcard(Long idcard) {
		this.idcard = idcard;
	}
	public Double getPricecard() {
		return pricecard;
	}
	public void setPricecard(Double pricecard) {
		this.pricecard = pricecard;
	}
	
	
	public Lists update(Long idlist, ListsRepository listsRepository) {
		///exemplo para montar edição de listas
		Lists lists = listsRepository.getById(idlist);
		lists.setNamelist(this.namelist);
		lists.setQtdcard(this.qtdcard);
		lists.setIdcard(idcard);
		lists.setIdplayer(idplayer);
		lists.setPricecard(pricecard);
		
		return lists;
	}
	
	
	
}
