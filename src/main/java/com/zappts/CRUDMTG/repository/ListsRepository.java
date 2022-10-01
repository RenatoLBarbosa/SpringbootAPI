package com.zappts.CRUDMTG.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zappts.CRUDMTG.model.Lists;

public interface ListsRepository extends JpaRepository<Lists, Integer> {

//	 public List<Lists> findAll();
}
