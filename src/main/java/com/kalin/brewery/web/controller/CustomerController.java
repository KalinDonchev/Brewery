package com.kalin.brewery.web.controller;

import com.kalin.brewery.services.CustomerService;
import com.kalin.brewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customer) {
        CustomerDto customerDto = customerService.createNewCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + customerDto.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    // It can be done with ResponseStatus here too
    @PutMapping("/{customerId}")
    public ResponseEntity updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId,customerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    // another way for returning a status instead of ResponseEntity
    // the ResponseStatus annotation returns an empty body
    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("customerId") UUID customerId) {
        customerService.deleteCustomer(customerId);
    }

}
