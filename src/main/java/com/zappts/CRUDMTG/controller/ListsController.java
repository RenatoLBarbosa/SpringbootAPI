package com.zappts.CRUDMTG.controller;

import java.io.IOException;
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

import com.zappts.CRUDMTG.config.validation.CardDoesNotExistException;
import com.zappts.CRUDMTG.config.validation.PlayerDoesNotExistException;
import com.zappts.CRUDMTG.dto.lists.ListsDto;
import com.zappts.CRUDMTG.form.lists.ListsForm;
import com.zappts.CRUDMTG.form.lists.UpdateListsForm;
import com.zappts.CRUDMTG.model.Card;
import com.zappts.CRUDMTG.model.Lists;
import com.zappts.CRUDMTG.model.Player;
import com.zappts.CRUDMTG.repository.ListsRepository;
import com.zappts.CRUDMTG.repository.PlayerRepository;

@RestController
@RequestMapping("/lists")
public class ListsController {

	@Autowired
	private ListsRepository listsRepository;
	private PlayerRepository playerRepository;
	private Lists lists;

	@GetMapping
	public List<ListsDto> select(Long idlist) throws IOException {

		List<Lists> lists = listsRepository.findAll();
		return ListsDto.converter(lists);

	}

	@PostMapping
	@Transactional
	public ResponseEntity<ListsDto> register(@RequestBody @Valid ListsForm form, UriComponentsBuilder uriBuilder)
			throws IOException {
		
		Lists lists = form.converter(listsRepository);

		Long idplayer = form.getPlayer().getIdplayer();

		Player player = playerRepository.findById(idplayer).orElseThrow(() -> new PlayerDoesNotExistException(idplayer));
		lists.setPlayer(player);

		listsRepository.save(lists);

		URI uri = uriBuilder.path("/lists/{idlist}").buildAndExpand(lists.getIdlist()).toUri();
		return ResponseEntity.created(uri).body(new ListsDto(lists));

	}

	@GetMapping("/{idlist}")
	public ResponseEntity<ListsDto> detail(Long idlist) {

		Optional<Lists> lists = listsRepository.findById(idlist);
		if (lists.isPresent()) {
			return ResponseEntity.ok(new ListsDto(lists.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{idlist}")
	@Transactional
	public ResponseEntity<ListsDto> update(Long idlist, @RequestBody @Valid UpdateListsForm form,
			UriComponentsBuilder uriBuilder) throws IOException {
		Optional<Lists> optional = listsRepository.findById(idlist);

		if (optional.isPresent()) {

			Lists lists = form.update(idlist, listsRepository);

//			Long idcard = form.getCard().getIdcard();
			Long idplayer = form.getPlayer().getIdplayer();

//			Card card = cardRepository.findById(idcard).orElseThrow(() -> new CardDoesNotExistException(idcard));
//			lists.setIdcard(card);

			Player player = playerRepository.findById(idplayer).orElseThrow(() -> new PlayerDoesNotExistException(idplayer));
			lists.setPlayer(player);

			listsRepository.save(lists);
			return ResponseEntity.ok(new ListsDto(lists));
		}
		URI uri = uriBuilder.path("/lists/{idlist}").buildAndExpand(lists.getIdlist()).toUri();
		return ResponseEntity.created(uri).body(new ListsDto(lists));
	}

	@DeleteMapping("/{idlist}")
	@Transactional
	public ResponseEntity<ListsDto> delete(Long idlist) {
		Optional<Lists> optional = listsRepository.findById(idlist);
		if (optional.isPresent()) {
			listsRepository.deleteById(idlist);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
