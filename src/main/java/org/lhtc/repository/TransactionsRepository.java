package org.lhtc.repository;

import org.lhtc.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository   extends
        JpaRepository<Transactions, Long>{

    Transactions findByTransactionId(Long transactionId);
}
