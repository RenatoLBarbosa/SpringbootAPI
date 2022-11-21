package com.zappts.CRUDMTG.dto.card;

import java.util.List;
import java.util.stream.Collectors;

import com.zappts.CRUDMTG.model.Card;

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
