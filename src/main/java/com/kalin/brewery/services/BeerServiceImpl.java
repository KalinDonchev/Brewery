package com.kalin.brewery.services;

import com.kalin.brewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDto getBeerById(UUID id) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Zagorka")
                .beerStyle("White")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        log.debug("Updating a beer...");
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleting a beer...");
    }
}
