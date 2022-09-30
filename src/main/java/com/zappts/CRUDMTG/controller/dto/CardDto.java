package com.zappts.CRUDMTG.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.zappts.CRUDMTG.model.Card;
import com.zappts.CRUDMTG.model.Language;

// para controle de qual retorno quero realizar na API
public class CardDto {

	private Integer idcard;
	private String namecard;
	private String edition;
	private Language language;
	private Boolean foil;
	private Double price;
	
	public CardDto(Card card) {
		this.idcard = card.getIdcard();
		this.namecard = card.getNamecard();
		this.edition = card.getEdition();
		this.language = card.getLanguage();
		this.foil = card.getFoil();
		this.price = card.getPrice();

	}
	
	public Integer getIdcard() {
		return idcard;
	}
	public String getNamecard() {
		return namecard;
	}
	public String getEdition() {
		return edition;
	}
	public Language getLanguage() {
		return language;
	}
	public Boolean getFoil() {
		return foil;
	}
	public Double getPrice() {
		return price;
	}
	
	
	public static List<CardDto> converter(List<Card> card) {
		return card.stream().map(CardDto::new).collect(Collectors.toList());
		
	}
	
}
