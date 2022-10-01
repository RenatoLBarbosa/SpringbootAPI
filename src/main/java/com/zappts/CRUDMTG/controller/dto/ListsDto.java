package com.zappts.CRUDMTG.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.zappts.CRUDMTG.model.Card;
import com.zappts.CRUDMTG.model.Lists;
import com.zappts.CRUDMTG.model.Player;

// para controle de qual retorno quero realizar na API
public class ListsDto {

	private Integer idlist;
	private String namelist;
	private int qtdcard;
	private Card idcard;
	private Player idplayer;
	
	public ListsDto(Lists lists) {
		this.idlist = lists.getIdlist();
		this.namelist = lists.getNamelist();
		this.qtdcard = lists.getQtdcard();
		this.idcard = lists.getIdcard();
		this.idplayer = lists.getIdplayer();
			
	}
	
	public Integer getIdlist() {
		return idlist;
	}
	public String getNamelist() {
		return namelist;
	}
	public int getQtdcard() {
		return qtdcard;
	}
	public Card getIdcard() {
		return idcard;
	}
	public Player getIdplayer() {
		return idplayer;
	}

	public static List<ListsDto> converter(List<Lists> lists){
		return lists.stream().map(ListsDto::new).collect(Collectors.toList());
		
	}
	
}
