package com.kalin.brewery.services;

import com.kalin.brewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID id);

    CustomerDto createNewCustomer(CustomerDto customer);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteCustomer(UUID customerId);

}
