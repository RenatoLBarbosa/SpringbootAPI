package com.zappts.CRUDMTG.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.zappts.CRUDMTG.dto.player.PlayerDto;
import com.zappts.CRUDMTG.form.player.PlayerForm;
import com.zappts.CRUDMTG.form.player.UpdatePlayerForm;
import com.zappts.CRUDMTG.model.Player;
import com.zappts.CRUDMTG.repository.PlayerRepository;

@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PlayerRepository playerRepository;
	private Player player;

	@GetMapping
	public List<PlayerDto> select(Long idplayer) {

		List<Player> player = playerRepository.findAll();
		return PlayerDto.converter(player);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PlayerDto> register(@RequestBody @Valid PlayerForm form, UriComponentsBuilder uriBuilder) {
		Player player = form.converter(playerRepository);
		playerRepository.save(player);

		URI uri = uriBuilder.path("/player/{idplayer}").buildAndExpand(player.getIdplayer()).toUri();
		return ResponseEntity.created(uri).body(new PlayerDto(player));
	}

//	@GetMapping("/{idplayer}")
//	public ResponseEntity<PlayerDto> detail(Long idplayer) {
//
//		Optional<Player> player = playerRepository.findById(idplayer);
//		if (player.isPresent()) {
//			return ResponseEntity.ok(new PlayerDto(player.get()));
//		}
//		return ResponseEntity.notFound().build();
//	}
	@GetMapping("/{username}")
	public ResponseEntity<PlayerDto> detail(String username) {

		Optional<Player> player = playerRepository.findByUsername(username);
		if (player.isPresent()) {
			return ResponseEntity.ok(new PlayerDto(player.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{idplayer}")
	@Transactional
	public ResponseEntity<PlayerDto> update(Long idplayer, @RequestBody @Valid UpdatePlayerForm form,
			UriComponentsBuilder uriBuilder) {
		Optional<Player> optional = playerRepository.findById(idplayer);
		if (optional.isPresent()) {
			Player player = form.update(idplayer, playerRepository);
			return ResponseEntity.ok(new PlayerDto(player));
		}
		URI uri = uriBuilder.path("/player/{idplayer}").buildAndExpand(player.getIdplayer()).toUri();
		return ResponseEntity.created(uri).body(new PlayerDto(player));
	}

	@DeleteMapping("/{idplayer}")
	@Transactional
	public ResponseEntity<PlayerDto> delete(Long idplayer) {
		Optional<Player> optional = playerRepository.findById(idplayer);
		if (optional.isPresent()) {
			playerRepository.deleteById(idplayer);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
