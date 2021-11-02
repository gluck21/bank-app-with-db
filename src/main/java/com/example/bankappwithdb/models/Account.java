package com.example.bankappwithdb.models;
import com.example.bankappwithdb.enums.AccountType;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Data
@Entity
public class Account {
    @Id
    private String accountNumber;
    private String accountType;
    private BigInteger balance;
    @OneToMany
    private List<AccountStatement> accountStatementList;
    private Date creatDt;


}
