package com.kalin.brewery.web.controller.v2;

import com.kalin.brewery.services.BeerService;
import com.kalin.brewery.services.v2.BeerServiceV2;
import com.kalin.brewery.web.model.BeerDto;
import com.kalin.brewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDtoV2 beerDtoV2){
        BeerDtoV2 savedDto = beerServiceV2.saveNewBeer(beerDtoV2);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v2/beer/" + savedDto.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    // It can be done with ResponseStatus here too
    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDtoV2){
        beerServiceV2.updateBeer(beerId,beerDtoV2);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    // another way for returning a status instead of ResponseEntity
    // the ResponseStatus annotation returns an empty body
    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerServiceV2.deleteBeer(beerId);
    }


}