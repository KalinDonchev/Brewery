package com.kalin.brewery.web.mappers;

import com.kalin.brewery.domain.Customer;
import com.kalin.brewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);

}
