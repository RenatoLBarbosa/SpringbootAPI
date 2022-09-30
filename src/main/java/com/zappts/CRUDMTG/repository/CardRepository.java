package com.zappts.CRUDMTG.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.zappts.CRUDMTG.model.Card;


public interface CardRepository extends JpaRepository<Card, Integer> {

//	List<Card> findByIdcard(Integer idcard);
	List<Card> findByNamecard(@Param(value = "namecard") String namecard);
	List<Card> findByedition(@Param(value = "edition") String edition);
	List<Card> findByFoil(@Param(value = "foil") Boolean foil);
	List<Card> findByPrice(@Param(value = "price") Double price);

}
