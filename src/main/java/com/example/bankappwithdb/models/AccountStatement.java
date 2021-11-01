package com.example.bankappwithdb.models;
import com.example.bankappwithdb.enums.TransactionType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Date;



@Data
@Entity
public class AccountStatement {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private Date transactionDate;
   private TransactionType transactionType;
   private BigInteger amount;
   private String narration;
   private BigInteger accountBalance;
}
