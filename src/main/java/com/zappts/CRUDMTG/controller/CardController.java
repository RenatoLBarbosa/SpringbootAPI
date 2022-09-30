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
import org.springframework.web.util.UriComponentsBuilder;


import com.zappts.CRUDMTG.controller.dto.CardDto;
import com.zappts.CRUDMTG.controller.dto.CardeditionDto;
import com.zappts.CRUDMTG.controller.dto.CardfoilDto;
import com.zappts.CRUDMTG.controller.dto.CardnameDto;
import com.zappts.CRUDMTG.controller.dto.CardpriceDto;
import com.zappts.CRUDMTG.controller.form.CardForm;
import com.zappts.CRUDMTG.controller.form.UpdateCardForm;
import com.zappts.CRUDMTG.model.Card;
import com.zappts.CRUDMTG.model.Language;
import com.zappts.CRUDMTG.repository.CardRepository;

@RestController
@RequestMapping("/card")
public class CardController {

	public Language idlangV;
	public String nomecardV;
	public String editionV;
	public Boolean foilV;
	public Double priceV;

	@Autowired
	private CardRepository cardRepository;

	@GetMapping
	public List<CardDto> select(Integer idcard) throws IOException {

		List<Card> card = cardRepository.findAll();
		return CardDto.converter(card);

	}

	@PostMapping
	@Transactional
	public ResponseEntity<CardDto> register(@RequestBody @Valid CardForm form, UriComponentsBuilder uriBuilder)
			throws IOException {
		Card card = form.converter(cardRepository);
		cardRepository.save(card);

		return ResponseEntity.notFound().build();

		/*
		 * OLD idlangV = card.getLanguage();
		 * 
		 * 
		 * URL urllang = new URL("http://localhost:8080/language/"+idlangV);
		 * 
		 * HttpURLConnection connectionlang = (HttpURLConnection)
		 * urllang.openConnection();
		 * 
		 * connectionlang.setRequestProperty("accept", "application/json");
		 * 
		 * InputStream responseStreamlang = connectionlang.getInputStream();
		 * 
		 * ObjectMapper mapper = new ObjectMapper();
		 * 
		 * Language lang = mapper.readValue(responseStreamlang, Language.class);
		 * 
		 * 
		 * if (idlangV == lang.idlang) { cardRepository.save(card);
		 * 
		 * URI uri =
		 * uriBuilder.path("/card/{id}").buildAndExpand(card.getIdcard()).toUri();
		 * return ResponseEntity.created(uri).body(new CardDto(card)); }
		 * 
		 */
	}

	@GetMapping("/{idcard}")
	public ResponseEntity<CardDto> detail(@PathVariable Integer idcard) {

		Optional<Card> card = cardRepository.findById(idcard);
		if (card.isPresent()) {
			return ResponseEntity.ok(new CardDto(card.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@RequestMapping("namecard") // por url padrão -> localhost:8080/card/namecard?namecard=card1
	public List<CardnameDto> listcardnamecard(String namecard) {
		if (namecard == null) {
			List<Card> card = cardRepository.findAll();
			return CardnameDto.converter(card);
		} else {
			List<Card> card = cardRepository.findByNamecard(namecard);
			return CardnameDto.converter(card);
		}

	}

	@RequestMapping("edition") // por url padrão -> localhost:8080/card/edition?edition=var
	public List<CardeditionDto> listcardedition(String edition) {
		if (edition == null) {
			List<Card> card = cardRepository.findAll();
			return CardeditionDto.converter(card);
		} else {
			List<Card> card = cardRepository.findByedition(edition);
			return CardeditionDto.converter(card);
		}

	}

	@RequestMapping("foil") // por url padrão -> localhost:8080/card/edition?foil=var
	public List<CardfoilDto> listcardfoil(Boolean foil) {
		if (foil == null) {
			List<Card> card = cardRepository.findAll();
			return CardfoilDto.converter(card);
		} else {
			List<Card> card = cardRepository.findByFoil(foil);
			return CardfoilDto.converter(card);
		}
	}

	@RequestMapping("price") // por url padrão -> localhost:8080/card/price?price=var
	public List<CardpriceDto> listcardprice(Double price) {
		if (price == null) {
			List<Card> card = cardRepository.findAll();
			return CardpriceDto.converter(card);
		} else {
			List<Card> card = cardRepository.findByPrice(price);
			return CardpriceDto.converter(card);
		}

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CardDto> update(@PathVariable("id") Integer idcard, @RequestBody @Valid UpdateCardForm form)
			throws IOException {

		Optional<Card> optional = cardRepository.findById(idcard);
		if (optional.isPresent()) {
			Card card = form.update(idcard, cardRepository);
			cardRepository.save(card);
		}
		return ResponseEntity.notFound().build();
		/*
		 * 
		 * idlangV = card.getLanguage();
		 * 
		 * URL urllang = new URL("http://localhost:8080/language/" + idlangV);
		 * 
		 * HttpURLConnection connectionlang = (HttpURLConnection)
		 * urllang.openConnection();
		 * 
		 * connectionlang.setRequestProperty("accept", "application/json");
		 * 
		 * InputStream responseStreamlang = connectionlang.getInputStream();
		 * 
		 * // Manually converting the response body InputStream to APOD using Jackson
		 * ObjectMapper mapper = new ObjectMapper();
		 * 
		 * Language lang = mapper.readValue(responseStreamlang, Language.class);
		 * 
		 * if (idlangV == lang.idlang) {
		 * 
		 * 
		 * 
		 * return ResponseEntity.ok(new CardDto(card));
		 * 
		 * }
		 */
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<CardDto> delete(@PathVariable("id") Integer idcard) {
		Optional<Card> optional = cardRepository.findById(idcard);
		if (optional.isPresent()) {
			cardRepository.deleteById(idcard);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
