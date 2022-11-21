package com.zappts.CRUDMTG.dto.card;

import java.util.List;
import java.util.stream.Collectors;

import com.zappts.CRUDMTG.model.Card;

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
