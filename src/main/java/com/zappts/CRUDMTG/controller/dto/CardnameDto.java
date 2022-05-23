package com.zappts.CRUDMTG.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.zappts.CRUDMTG.model.Card;

// para controle de qual retorno quero realizar na API
public class CardnameDto {
	private String namecard;

	
	public CardnameDto(Card card) {
		this.namecard = card.getNamecard();
	}
	

	public String getNamecard() {
		return namecard;
	}
	
	
	
	public static List<CardnameDto> converter(List<Card> card) {
		return card.stream().map(CardnameDto::new).collect(Collectors.toList());
		
	}
	
}
