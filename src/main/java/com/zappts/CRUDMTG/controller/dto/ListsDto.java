package com.zappts.CRUDMTG.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.zappts.CRUDMTG.model.Lists;

// para controle de qual retorno quero realizar na API
public class ListsDto {

	private Long idlist;
	private String namelist;
	private int qtdcard;
	private Long idcard;
	private Long idplayer;
	private Double pricecard;
	
	public ListsDto(Lists lists) {
		this.idlist = lists.getIdlist();
		this.namelist = lists.getNamelist();
		this.qtdcard = lists.getQtdcard();
		this.idcard = lists.getIdcard();
		this.idplayer = lists.getIdplayer();
		this.pricecard = lists.getPricecard();
			
	}
	
	public Long getIdlist() {
		return idlist;
	}
	public String getNamelist() {
		return namelist;
	}
	public int getQtdcard() {
		return qtdcard;
	}
	public Long getIdcard() {
		return idcard;
	}
	public Long getIdplayer() {
		return idplayer;
	}
	public Double getPricecard() {
		return pricecard;
	}

	public static List<ListsDto> converter(List<Lists> lists){
		return lists.stream().map(ListsDto::new).collect(Collectors.toList());
		
	}
	
}
