package com.example.bankappwithdb.services.serviceImpl;

import com.example.bankappwithdb.dto.CustomerDto;
import com.example.bankappwithdb.dto.ResponseBody;
import com.example.bankappwithdb.enums.Roles;
import com.example.bankappwithdb.exceptions.AppExceptions;
import com.example.bankappwithdb.models.Account;
import com.example.bankappwithdb.models.Customer;
import com.example.bankappwithdb.repository.AccountRepository;
import com.example.bankappwithdb.repository.CustomerRepository;
import com.example.bankappwithdb.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
   private final CustomerRepository customerRepository;
   private final AccountRepository accountRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }


    @Override
    public ResponseEntity<?> createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        UUID uuid = UUID.randomUUID();
        String generateAccountNumber = uuid.toString();
        generateAccountNumber = generateAccountNumber.substring(26,generateAccountNumber.length());
        generateAccountNumber = "0x"+generateAccountNumber;
        generateAccountNumber = (Long.decode(generateAccountNumber)).toString();
        generateAccountNumber = generateAccountNumber.substring(0,10);
        customer.setFullName(customerDto.getFullName());
        System.out.println(customerDto.getFullName());
        customer.setUserName(customerDto.getUserName());
        System.out.println(customerDto.getUserName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setAddress(customerDto.getAddress());
        customer.setPassword(customerDto.getPassword());
        customer.setRoles(Roles.CUSTOMER);
        Account account = new Account();
        account.setAccountNumber(generateAccountNumber);
        account.setAccountType(customerDto.getAccountType());
//        account.setBalance();
        account.setCreatDt(new Date());
        customer.setAccount(accountRepository.save(account));
        ResponseBody responseBody = new ResponseBody();
        Optional<Customer> dbCustomer = customerRepository.getCustomerByEmailAndPassword(customer.getEmail(), customer.getPassword());
        if (dbCustomer.isEmpty()) {
            customerRepository.save(customer);
            responseBody.setData(customer);
            responseBody.setMessage("Registration Successful");
            return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
        }
        throw new AppExceptions("Email already in use",HttpStatus.BAD_REQUEST);
    }


//        user.setAccountPassword(passwordEncoder.encode(userPassWord));
//        if(customerDto.getInitialDeposit()>=500){
//            user.setAccountBalance(initialDeposit);
//        }
//        else throw  new MinimumInitialDepositException("initial deposit must be 500 naira and above");
//        bankDataBase.addUser(user);

    }

