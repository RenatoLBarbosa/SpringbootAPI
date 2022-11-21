package com.zappts.CRUDMTG.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zappts.CRUDMTG.model.CardList;


public interface ListPlayerRepository extends JpaRepository<CardList, Long> {

}
