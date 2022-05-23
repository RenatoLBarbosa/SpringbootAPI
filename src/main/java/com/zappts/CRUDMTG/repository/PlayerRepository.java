package com.zappts.CRUDMTG.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zappts.CRUDMTG.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	List<Player> findByIdplayer(Long idplayer);
	
	
	// List<Player> findByPlayernamePlayer(String nameplayer);
 // faz o filtro pelo relacionamento de outra classe 
}
