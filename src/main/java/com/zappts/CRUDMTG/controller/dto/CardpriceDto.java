package com.zappts.CRUDMTG.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.zappts.CRUDMTG.model.Card;

// para controle de qual retorno quero realizar na API
public class CardpriceDto {
	private Double price;
	
	public CardpriceDto(Card card) {
		this.price = card.getPrice();
	}
	
	public Double getPrice() {
		return price;
	}


	public static List<CardpriceDto> converter(List<Card> card) {
		return card.stream().map(CardpriceDto::new).collect(Collectors.toList());
		
	}
	
}
