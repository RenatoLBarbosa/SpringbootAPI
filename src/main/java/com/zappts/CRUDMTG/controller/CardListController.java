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
import com.zappts.CRUDMTG.config.validation.ListsDoesNotExistException;
import com.zappts.CRUDMTG.config.validation.PlayerDoesNotExistException;
import com.zappts.CRUDMTG.dto.cardlist.CardListDto;
import com.zappts.CRUDMTG.form.cardlist.CardListForm;
import com.zappts.CRUDMTG.form.cardlist.UpdateCardListForm;
import com.zappts.CRUDMTG.model.Card;
import com.zappts.CRUDMTG.model.CardList;
import com.zappts.CRUDMTG.model.Lists;
import com.zappts.CRUDMTG.model.Player;
import com.zappts.CRUDMTG.repository.CardRepository;
import com.zappts.CRUDMTG.repository.ListPlayerRepository;
import com.zappts.CRUDMTG.repository.ListsRepository;

@RestController
@RequestMapping("/cl")
public class CardListController {

	@Autowired
	private ListsRepository listsRepository;
	private ListPlayerRepository lpRepository;
	private CardRepository cardRepository;
	private CardList cl;

	@GetMapping
	public List<CardListDto> select(Long idcl)  throws IOException{

		List<CardList> lp = lpRepository.findAll();
		return CardListDto.converter(lp);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<CardListDto> register(@RequestBody @Valid CardListForm form, UriComponentsBuilder uriBuilder) throws IOException {
		CardList cl = form.converter(lpRepository);
		
		Long idcard = form.getCard().getIdcard();
		Long idlist = form.getLists().getIdlist();
		
		Card card = cardRepository.findById(idcard).orElseThrow(() -> new PlayerDoesNotExistException(idcard));
		cl.setCard(card);
		Lists lists = listsRepository.findById(idlist).orElseThrow(() -> new ListsDoesNotExistException(idlist));
		cl.setLists(lists);
	
		lpRepository.save(cl);

//		URI uri = uriBuilder.path("/lp/{idlp}").buildAndExpand(lp.getIdlp()).toUri();
//		return ResponseEntity.created(uri).body(new ListPlayerDto(lp));
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{idcl}")
	public ResponseEntity<CardListDto> detail(Long idcl) {

		Optional<CardList> cl = lpRepository.findById(idcl);
		if (cl.isPresent()) {
			return ResponseEntity.ok(new CardListDto(cl.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{idcl}")
	@Transactional
	public ResponseEntity<CardListDto> update(Long idcl, @RequestBody @Valid UpdateCardListForm form, UriComponentsBuilder uriBuilder)
			throws IOException {
		Optional<Lists> optional = listsRepository.findById(idcl);
		
		if (optional.isPresent()) {
		
			CardList cl = form.update(idcl, lpRepository);
			
			Long idcard = form.getCard().getIdcard();
			Long idlist = form.getLists().getIdlist();
			
			Card card = cardRepository.findById(idcard).orElseThrow(() -> new CardDoesNotExistException(idcard));
			cl.setCard(card);
			Lists lists = listsRepository.findById(idlist).orElseThrow(() -> new ListsDoesNotExistException(idlist));
			cl.setLists(lists);
		
			lpRepository.save(cl);
		}
		URI uri = uriBuilder.path("/lp/{idlp}").buildAndExpand(cl.getIdcl()).toUri();
		return ResponseEntity.created(uri).body(new CardListDto(cl));
	}

	@DeleteMapping("/{idlp}")
	@Transactional
	public ResponseEntity<CardListDto> delete(Long idlp) {
		Optional<CardList> optional = lpRepository.findById(idlp);
		if (optional.isPresent()) {
			listsRepository.deleteById(idlp);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
