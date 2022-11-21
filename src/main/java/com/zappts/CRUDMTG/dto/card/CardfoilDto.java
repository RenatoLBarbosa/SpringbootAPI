package com.zappts.CRUDMTG.dto.card;

import java.util.List;
import java.util.stream.Collectors;

import com.zappts.CRUDMTG.model.Card;

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
