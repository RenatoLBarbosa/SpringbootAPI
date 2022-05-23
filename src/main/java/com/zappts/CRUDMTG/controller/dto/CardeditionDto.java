package com.zappts.CRUDMTG.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.zappts.CRUDMTG.model.Card;

// para controle de qual retorno quero realizar na API
public class CardeditionDto {
	private String edition;
	
	public CardeditionDto(Card card) {
		this.edition = card.getEdition();
	}
	
	public String getEdition() {
		return edition;
	}


	public static List<CardeditionDto> converter(List<Card> card) {
		return card.stream().map(CardeditionDto::new).collect(Collectors.toList());
		
	}
	
}
