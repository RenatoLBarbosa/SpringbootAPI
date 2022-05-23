package com.zappts.CRUDMTG.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.zappts.CRUDMTG.model.Language;

public interface LanguageRepository extends JpaRepository<Language, Long>{

//	Language findByLang(String lang);

//	Language findByLang(@NotNull @NotEmpty Map<String, String> language);
	Language findByIdlang(Language idlang);


}
