package com.ostd.rest.repository;

import com.ostd.rest.domain.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
}
