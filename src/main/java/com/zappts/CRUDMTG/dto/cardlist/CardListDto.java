package com.zappts.CRUDMTG.dto.cardlist;

import java.util.List;
import java.util.stream.Collectors;

import com.zappts.CRUDMTG.model.Card;
import com.zappts.CRUDMTG.model.CardList;
import com.zappts.CRUDMTG.model.Lists;
import com.zappts.CRUDMTG.model.Player;

public class CardListDto {

	private Long idcl;
	private Card card;
	private Lists lists;

	public CardListDto(CardList cl) {
		this.idcl = cl.getIdcl();
		this.card = cl.getCard();
		this.lists = cl.getLists();

	}

	public Long getIdcl() {
		return idcl;
	}
	public Card getCard() {
		return card;
	}
	public Lists getLists() {
		return lists;
	}

	public static List<CardListDto> converter(List<CardList> lp) {
		return lp.stream().map(CardListDto::new).collect(Collectors.toList());

	}

}
