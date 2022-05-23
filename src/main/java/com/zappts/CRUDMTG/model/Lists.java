package com.zappts.CRUDMTG.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Lists {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idlist;
	private String namelist;
	private int qtdcard;
	private Long idcard;
	private Long idplayer;
	private Double pricecard;
	
	public Lists() {
	}
	
	public Lists(String namelist, int qtdcard, Long idcard, Long idplayer, Double pricecard) {
		this.namelist = namelist;
		this.qtdcard = qtdcard;
		this.idcard = idcard;
		this.idplayer = idplayer;
		this.pricecard = pricecard;
	}
	

	public Long getIdcard() {
		return idcard;
	}
	public void setIdcard(Long idcard) {
		this.idcard = idcard;
	}
	public Long getIdplayer() {
		return idplayer;
	}
	public void setIdplayer(Long idplayer) {
		this.idplayer = idplayer;
	}
	public String getNamelist() {
		return namelist;
	}
	public void setNamelist(String namelist) {
		this.namelist = namelist;
	}
	public int getQtdcard() {
		return qtdcard;
	}
	public void setQtdcard(int qtdcard) {
		this.qtdcard = qtdcard;
	}
	public Long getIdlist() {
		return idlist;
	}
	public Double getPricecard() {
		return pricecard;
	}
	public void setPricecard(Double pricecard) {
		this.pricecard = pricecard;
	}
		
}
