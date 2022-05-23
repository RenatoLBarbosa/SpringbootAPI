package com.zappts.CRUDMTG.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Language {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @JsonProperty("idlang")
	public long idlang;
	@JsonProperty("lang")
	private String lang;
	
	
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public Long getIdlang() {
		return idlang;
	}
	
	
}
