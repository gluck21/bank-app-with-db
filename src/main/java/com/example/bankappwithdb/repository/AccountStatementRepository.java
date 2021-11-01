package com.example.bankappwithdb.repository;

import com.example.bankappwithdb.models.AccountStatement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountStatementRepository extends JpaRepository<AccountStatement, Long> {
}
