package com.zappts.CRUDMTG.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.zappts.CRUDMTG.model.Card;

// para controle de qual retorno quero realizar na API
public class CardDto {

	private Long idcard;
	private String namecard;
	private String edition;
	private Long idlang;
	private Boolean foil;
	private Double price;
	
	public CardDto(Card card) {
		this.idcard = card.getIdcard();
		this.namecard = card.getNamecard();
		this.edition = card.getEdition();
		this.idlang = card.getIdlang();
		this.foil = card.getFoil();
		this.price = card.getPrice();

	}
	
	public Long getIdcard() {
		return idcard;
	}
	public String getNamecard() {
		return namecard;
	}
	public String getEdition() {
		return edition;
	}
	public Long getIdlang() {
		return idlang;
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
