package com.zappts.CRUDMTG.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "cardlist")
public class CardList {
	
	@Id
	@GeneratedValue
	@Column(name="idcl")
	private Long idcl;
	
	@JoinColumn(name = "idlist")
	@JsonIgnore
	@JsonManagedReference
	@ManyToOne
	private Lists lists;
	
	@JoinColumn(name = "idcard")
	@JsonIgnore
	@JsonManagedReference
	@ManyToOne
	private Card card;
	
	@Column(name="qtdcard")
	private Integer qtdcard;

	public CardList(Lists lists, Card card, Integer qtdcard) {
		this.lists = lists;
		this.card = card;
		this.qtdcard = qtdcard;
	}
	
	public CardList() {
		
	}

	public Long getIdcl() {
		return idcl;
	}
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

	public int getQtdcard() {
		return qtdcard;
	}

	public void setQtdcard(Integer qtdcard) {
		this.qtdcard = qtdcard;
	}

}
