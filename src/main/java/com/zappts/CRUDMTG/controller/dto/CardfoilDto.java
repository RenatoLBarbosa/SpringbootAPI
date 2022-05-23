package com.zappts.CRUDMTG.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.zappts.CRUDMTG.model.Card;

// para controle de qual retorno quero realizar na API
public class CardfoilDto {
	private Boolean foil;
	
	public CardfoilDto(Card card) {
		this.foil = card.getFoil();
	}
	
	public Boolean getFoil() {
		return foil;
	}


	public static List<CardfoilDto> converter(List<Card> card) {
		return card.stream().map(CardfoilDto::new).collect(Collectors.toList());
		
	}
	
}
