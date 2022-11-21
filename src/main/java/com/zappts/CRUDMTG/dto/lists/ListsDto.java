package com.zappts.CRUDMTG.dto.lists;

import java.util.List;
import java.util.stream.Collectors;

import com.zappts.CRUDMTG.model.Card;
import com.zappts.CRUDMTG.model.Lists;
import com.zappts.CRUDMTG.model.Player;

public class ListsDto {

	private Long idlist;
	private String namelist;
	private Player player;
	private double pricelist;

	public ListsDto(Lists lists) {
		this.idlist = lists.getIdlist();
		this.namelist = lists.getNamelist();
		this.pricelist = lists.getPricelist();
		this.player = lists.getPlayer();

	}
	
	public Long getIdlist() {
		return idlist;
	}
	public String getNamelist() {
		return namelist;
	}
	public Player getPlayer() {
		return player;
	}

	public double getPricelist() {
		return pricelist;
	}

	public static List<ListsDto> converter(List<Lists> lists) {
		return lists.stream().map(ListsDto::new).collect(Collectors.toList());

	}

}
