package org.lhtc.repository;

import org.lhtc.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository  extends
        JpaRepository<Account, Long>{

    Account findByAccountId(Long accountId);
}
