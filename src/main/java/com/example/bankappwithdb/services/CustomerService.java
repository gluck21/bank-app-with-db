package com.example.bankappwithdb.services;

import com.example.bankappwithdb.dto.CustomerDto;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    ResponseEntity<?> createCustomer(CustomerDto customerDto);
}
