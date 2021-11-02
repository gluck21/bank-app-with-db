package com.example.bankappwithdb.controller;


import com.example.bankappwithdb.dto.CustomerDto;
import com.example.bankappwithdb.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create-customer")
public ResponseEntity<?> CreateCustomer(@RequestBody CustomerDto customerDto){
        return customerService.createCustomer(customerDto);
}
}
