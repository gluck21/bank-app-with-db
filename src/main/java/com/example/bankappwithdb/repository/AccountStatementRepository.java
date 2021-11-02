package com.example.bankappwithdb.repository;

import com.example.bankappwithdb.models.AccountStatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountStatementRepository extends JpaRepository<AccountStatement, Long> {
}
