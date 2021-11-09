package com.kalin.brewery.services;

import com.kalin.brewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID id);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeer(UUID beerId);
}
