package com.kalin.brewery.web.controller;

import com.kalin.brewery.services.BeerService;
import com.kalin.brewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Deprecated
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDto beerDto){
        BeerDto savedDto = beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    // It can be done with ResponseStatus here too
    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto){
        beerService.updateBeer(beerId,beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    // another way for returning a status instead of ResponseEntity
    // the ResponseStatus annotation returns an empty body
    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeer(beerId);
    }



}
