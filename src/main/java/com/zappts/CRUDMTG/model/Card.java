package com.zappts.CRUDMTG.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="card")
public class Card {
	
	@Id
	@GeneratedValue
	@Column(name="idcard")
	public Long idcard;
	
	@Column(name="namecard")
	public String namecard;
	
	@Column(name="edition")
	public String edition;
	
	@Column(name="language")
	@Enumerated(EnumType.STRING)
	public Language language;
	
	@Column(name="foil")
	public Boolean foil;
	
	@Column(name="price")
	public Double price;
	
	@JsonBackReference
	@OneToMany(mappedBy = "card", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CardList> cardlist;
	
	public Card() {
		this.cardlist = new ArrayList<>();
	}

	
	public Card(String namecard, String edition, Language language, Boolean foil, Double price) {
		this.namecard = namecard;
		this.edition = edition;
		this.language = language;
		this.foil = foil;
		this.price = price;
		this.cardlist = new ArrayList<>();
	}
	
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public String getNamecard() {
		return namecard;
	}
	public void setNamecard(String namecard) {
		this.namecard = namecard;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Boolean getFoil() {
		return foil;
	}
	public void setFoil(Boolean foil) {
		this.foil = foil;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getIdcard() {
		return idcard;
	}
	public List<CardList> getCardlist() {
		return cardlist;
	}
	public void setCardlist(List<CardList> cardlist) {
		this.cardlist = cardlist;
	}
	
}
