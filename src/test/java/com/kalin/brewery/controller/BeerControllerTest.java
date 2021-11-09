package com.kalin.brewery.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kalin.brewery.services.BeerService;
import com.kalin.brewery.web.controller.BeerController;
import com.kalin.brewery.web.model.BeerDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
public class BeerControllerTest {

    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    BeerDto validBeer;

    @Before
    public void setUp(){
        validBeer = BeerDto.builder().id(UUID.randomUUID())
                .beerName("Zagorka")
                .beerStyle("White")
                .upc(123L)
                .build();
    }

//    @Test
//    public void getBeer() {
//        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);
//
//        mockMvc.perform(("/api/v1/beer", validBeer.getId(),toString()).accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id", is(validBeer.getId().toString())))
//                .andExpect(jsonPath("$.beerName",is("Zagorka")));
//    }


}
