package com.example.bankappwithdb.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private String fullName;
    private String userName;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
    private String accountType;
}
