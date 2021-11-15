package com.kalin.brewery.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kalin.brewery.services.BeerService;
import com.kalin.brewery.web.controller.BeerController;
import com.kalin.brewery.web.model.BeerDto;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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
    public void setUp() {
        validBeer = BeerDto.builder().id(UUID.randomUUID())
                .beerName("Zagorka")
                .beerStyle("White")
                .upc(123L)
                .build();
    }

//    @Test
//    public void getBeer() throws Exception {
//        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" + validBeer.getId(),toString()).accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(validBeer.getId().toString())))
//
//                .andExpect(status().isOk())
//                .andExpect(MockRestRequestMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(validBeer.getId().toString())))
//                .andExpect((ResultMatcher) jsonPath("$.beerName",is("Zagorka")));
//    }

//    @Test
//    public void handlePost() throws Exception {
//        //given
//        BeerDto beerDto = validBeer;
//        beerDto.setId(null);
//        BeerDto savedDto = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").build();
//        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
//
//        given(beerService.saveNewBeer(any())).willReturn(savedDto);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(beerDtoJson))
//                .andExpect(status().isCreated());
//
//    }


//    @Test
//    public void handleUpdate() throws Exception {
//
//        //given
//        BeerDto beerDto = validBeer;
//        String beerDtoToJson = objectMapper.writeValueAsString(beerDto);
//
//        //when
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/" + UUID.randomUUID())
//        .contentType(MediaType.APPLICATION_JSON)
//        .content(beerDtoToJson))
//                .andExpect(status().isNoContent());
//
//        then(beerService).should().updateBeer(any(),any());
//    }

}
