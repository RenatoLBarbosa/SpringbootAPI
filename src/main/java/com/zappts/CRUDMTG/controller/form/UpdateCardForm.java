package com.zappts.CRUDMTG.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.zappts.CRUDMTG.model.Card;
import com.zappts.CRUDMTG.model.Language;
import com.zappts.CRUDMTG.repository.CardRepository;

public class UpdateCardForm {

	@NotNull @NotEmpty
	private String namecard;
	@NotNull @NotEmpty
	private String edition;
	@NotNull 
	private Language language; 
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

	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
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
	public Card update(Integer idcard, CardRepository cardRepository) {
		Card card = cardRepository.getById(idcard);
		card.setNamecard(this.namecard);
		card.setEdition(this.edition);
		card.setLanguage(language);
		card.setFoil(this.foil);
		card.setPrice(this.price);
		
		return card;
	}
	
	
	
}
