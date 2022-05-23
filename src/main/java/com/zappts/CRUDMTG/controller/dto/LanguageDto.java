package com.zappts.CRUDMTG.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.zappts.CRUDMTG.model.Language;

// para controle de qual retorno quero realizar na API
public class LanguageDto {

	private long idlang;
	private String lang;
	
	public LanguageDto(Language language) {
		this.idlang = language.getIdlang();
		this.lang = language.getLang();
	}

	public long getIdlang() {
		return idlang;
	}

	public void setIdlang(long idlang) {
		this.idlang = idlang;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	
	public static List<LanguageDto> converter(List<Language> language){
		return language.stream().map(LanguageDto::new).collect(Collectors.toList());
		
	}
	
}
