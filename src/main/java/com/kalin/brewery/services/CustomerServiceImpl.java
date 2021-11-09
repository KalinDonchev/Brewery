package com.kalin.brewery.services;

import com.kalin.brewery.web.model.BeerDto;
import com.kalin.brewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Ivan")
                .build();
    }

    @Override
    public CustomerDto createNewCustomer(CustomerDto customer) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Pesho")
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.debug("Updating customer");
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Deleting customer");
    }
}
