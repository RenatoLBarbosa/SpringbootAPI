package com.zappts.CRUDMTG.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "player")
public class Player {

	@Id
	@GeneratedValue
	@Column(name = "idplayer")
	public Long idplayer;

	@Column(name = "username")
	private String username;
	
	@Column(name = "pwd")
	private String pwd;

	@OneToMany(mappedBy = "player", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Lists> lists;

	public Player() {
		this.lists = new ArrayList<>();
	}
	
	public Player(String username, String pwd) {
		this.username = username;
		this.pwd = pwd;
		this.lists = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Long getIdplayer() {
		return idplayer;
	}
	public List<Lists> getLists() {
		return lists;
	}
	public void setLists(List<Lists> lists) {
		this.lists = lists;
	}

}
