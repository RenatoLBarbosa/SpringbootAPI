package com.zappts.CRUDMTG.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zappts.CRUDMTG.config.validation.CardDoesNotExistException;
import com.zappts.CRUDMTG.config.validation.PlayerDoesNotExistException;
import com.zappts.CRUDMTG.controller.dto.ListsDto;
import com.zappts.CRUDMTG.controller.form.ListsForm;
import com.zappts.CRUDMTG.controller.form.UpdateListsForm;
import com.zappts.CRUDMTG.model.Card;
import com.zappts.CRUDMTG.model.Lists;
import com.zappts.CRUDMTG.model.Player;
import com.zappts.CRUDMTG.repository.CardRepository;
import com.zappts.CRUDMTG.repository.ListsRepository;
import com.zappts.CRUDMTG.repository.PlayerRepository;

@RestController
@RequestMapping("/lists")
public class ListsController {

//	public Integer idcardV;
//	public Integer idplayerV;

	@Autowired
	private ListsRepository listsRepository;

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private PlayerRepository playerRepository;

	@GetMapping
	public List<ListsDto> select(Integer idlist)  throws IOException{

		List<Lists> lists = listsRepository.findAll();
		return ListsDto.converter(lists);

	}

	@PostMapping(consumes = "application/json")
	@Transactional
	public ResponseEntity<ListsDto> register(@RequestBody ListsForm form) throws IOException {
		Lists lists = form.converter(listsRepository);
		
		Integer idcard = form.getCard().getIdcard();
		
		Card card = cardRepository.findById(idcard).orElseThrow(() -> new CardDoesNotExistException(idcard));
		lists.setIdcard(card);
		
		Integer idplayer = form.getPlayer().getIdplayer();
		Player player = playerRepository.findById(idplayer)
				.orElseThrow(() -> new PlayerDoesNotExistException(idplayer));
		lists.setIdplayer(player);
//		
		listsRepository.save(lists);

//		System.out.println(json);
//		System.out.println("idcard" + lists.getIdcard() + " idplayer " + lists.getIdplayer());

		return ResponseEntity.notFound().build();


	}

	@GetMapping("/{id}")
	public ResponseEntity<ListsDto> detail(@PathVariable("id") Integer idlist) {

		Optional<Lists> lists = listsRepository.findById(idlist);
		if (lists.isPresent()) {
			return ResponseEntity.ok(new ListsDto(lists.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ListsDto> update(@PathVariable("id") Integer idlist, @RequestBody @Valid UpdateListsForm form)
			throws IOException {
		Optional<Lists> optional = listsRepository.findById(idlist);
//		if (optional.isPresent()) {
//			Lists lists = form.update(idlist, listsRepository);
//			idcardV = lists.getIdcard();
//			idplayerV = lists.getIdplayer();
//
//			URL urlcard = new URL("http://localhost:8080/card/" + idcardV);
//			URL urlplayer = new URL("http://localhost:8080/player/" + idplayerV);
//
//			HttpURLConnection connectioncard = (HttpURLConnection) urlcard.openConnection();
//			HttpURLConnection connectionplayer = (HttpURLConnection) urlplayer.openConnection();
//
//			connectioncard.setRequestProperty("accept", "application/json");
//			connectionplayer.setRequestProperty("accept", "application/json");
//
//			InputStream responseStreamcard = connectioncard.getInputStream();
//			InputStream responseStreamplayer = connectionplayer.getInputStream();
//
//			ObjectMapper mapper = new ObjectMapper();
//
//			Card card = mapper.readValue(responseStreamcard, Card.class);
//			Player player = mapper.readValue(responseStreamplayer, Player.class);
//
//			if (idcardV == card.idcard && idplayerV == player.idplayer) {
//				return ResponseEntity.ok(new ListsDto(lists));
//			}
//		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<ListsDto> delete(@PathVariable("id") Integer idlist) {
		Optional<Lists> optional = listsRepository.findById(idlist);
		if (optional.isPresent()) {
			listsRepository.deleteById(idlist);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
