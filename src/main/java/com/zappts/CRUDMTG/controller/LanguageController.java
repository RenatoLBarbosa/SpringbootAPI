package com.zappts.CRUDMTG.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zappts.CRUDMTG.controller.dto.LanguageDto;
import com.zappts.CRUDMTG.model.Language;
import com.zappts.CRUDMTG.repository.LanguageRepository;

@RestController
@RequestMapping("/language")
public class LanguageController {

	
	@Autowired
	private LanguageRepository languageRepository;
	

	
		@GetMapping
		public List<LanguageDto> select(Long idlang) {
			
			List<Language> language = languageRepository.findAll();
			return LanguageDto.converter(language);
			
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<LanguageDto> detail(@PathVariable("id") Long idlang) {
			
			Optional<Language> language = languageRepository.findById(idlang);
			if(language.isPresent()){
				return ResponseEntity.ok(new LanguageDto(language.get()));
			}
			return ResponseEntity.notFound().build();
		}
}
