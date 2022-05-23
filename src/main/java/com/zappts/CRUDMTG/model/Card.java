package com.zappts.CRUDMTG.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idcard;
	public String namecard;
	public String edition;
	public Long idlang;
	public Boolean foil;
	public Double price;
	
	
	public Card() {
	}

	
	public Card(String namecard, String edition, Long idlang, Boolean foil, Double price) {
		this.namecard = namecard;
		this.edition = edition;
		this.idlang = idlang;
		this.foil = foil;
		this.price = price;
	}
	


	public Long getIdlang() {
		return idlang;
	}
	public void setIdlang(Long idlang) {
		this.idlang = idlang;
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
	
	
}
