package com.zappts.CRUDMTG;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zappts.CRUDMTG.controller.CardController;
import com.zappts.CRUDMTG.model.Card;
import com.zappts.CRUDMTG.repository.CardRepository;

import javassist.NotFoundException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@WebMvcTest(CardController.class)
public class CardControllerTest {


	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private CardRepository cardRepository;
	
	List<Card> card = new ArrayList<>();
	Card RECORD_1 = new Card("card3","edt2",(long) 2,(Boolean) false,1.12);
	Card RECORD_2 = new Card("card4","edt1",(long) 1,(Boolean) true,2.20);
//	new Card("card5","edt3",(long) 3,(Boolean) true,1.30);
//	new Card("card6","edt2",(long) 1,(Boolean) false,4.21);
	
	@Test
	public void testListCard() throws Exception {
		List<Card> card = new ArrayList<>();
		card.add(new Card("card3","edt2",(long) 2,(Boolean) false,1.12));
		card.add(new Card("card4","edt1",(long) 1,(Boolean) true,2.20));
		card.add(new Card("card5","edt3",(long) 3,(Boolean) true,1.30));
		card.add(new Card("card6","edt2",(long) 1,(Boolean) false,4.21));
		
		Mockito.when(cardRepository.findAll()).thenReturn(card);
		
		String url = "/card";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
	            .get(url)
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andReturn();
		
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		System.out.println(actualJsonResponse);

	}
	
	@Test
	public void testListbyIdCard() throws Exception {
		Mockito.when(cardRepository.findById(RECORD_1.getIdcard())).thenReturn(java.util.Optional.of(RECORD_1));
		
		String url = "/card";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
	            .get(url)
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andReturn();
		
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		System.out.println(actualJsonResponse);
	}
		
}
