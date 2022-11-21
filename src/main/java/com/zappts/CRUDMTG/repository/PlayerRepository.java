package com.zappts.CRUDMTG.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zappts.CRUDMTG.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	List<Player> findByIdplayer(Long idplayer);

	Optional<Player> findByUsername(String username);
	
	
}
