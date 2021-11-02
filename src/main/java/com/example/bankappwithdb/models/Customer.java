package com.example.bankappwithdb.models;

import com.example.bankappwithdb.enums.Roles;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String fullName;
    private String userName;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
    @OneToOne
    private Account account;
    private Roles roles;


//    private Boolean isEnabled;
}
