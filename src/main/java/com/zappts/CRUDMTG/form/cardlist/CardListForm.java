package com.zappts.CRUDMTG.form.cardlist;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.zappts.CRUDMTG.model.Card;
import com.zappts.CRUDMTG.model.CardList;
import com.zappts.CRUDMTG.model.Lists;
import com.zappts.CRUDMTG.repository.ListPlayerRepository;

public class CardListForm {

	@NotNull
	@NotEmpty
	private Card card;
	@NotNull
	@NotEmpty
	private Lists lists;
	@NotNull
	@NotEmpty
	private Integer qtdcard;

	public Lists getLists() {
		return lists;
	}

	public void setLists(Lists lists) {
		this.lists = lists;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Integer getQtdcard() {
		return qtdcard;
	}

	public void setQtdcard(Integer qtdcard) {
		this.qtdcard = qtdcard;
	}

	public CardList converter(ListPlayerRepository lpRepository) {
		return new CardList(lists,card,qtdcard);
	}

}
