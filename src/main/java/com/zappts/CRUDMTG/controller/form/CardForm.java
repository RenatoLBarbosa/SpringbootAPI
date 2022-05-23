package com.zappts.CRUDMTG.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.zappts.CRUDMTG.model.Card;
import com.zappts.CRUDMTG.repository.CardRepository;


public class CardForm {

	@NotNull @NotEmpty
	private String namecard;
	@NotNull @NotEmpty
	private String edition;
	@NotNull //@NotEmpty
	private Long idlang; 
	@NotNull 
	private Boolean foil;
	@NotNull
	private Double price;
	
	public String getNamecard() {
		return namecard;
	}
	public void setNamecard(String namecard) {
		this.namecard = namecard;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Long getIdlang() {
		return idlang;
	}
	public void setIdlang(Long idlang) {
		this.idlang = idlang;
	}
	public Boolean getFoil() {
		return foil;
	}
	public void setFoil(Boolean foil) {
		this.foil = foil;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Card converter(CardRepository cardRepository) {

		return new Card(namecard,edition,idlang,foil,price);
	}
	
	
}
