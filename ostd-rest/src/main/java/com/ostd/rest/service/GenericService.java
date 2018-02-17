package com.ostd.rest.service;

import com.ostd.rest.domain.BankAccount;
import com.ostd.rest.domain.User;

import java.util.List;

public interface GenericService {

    BankAccount addBankAccount(BankAccount city);

    BankAccount editBankAccount(BankAccount bankAccount);

    void deleteBankAccount(Long accountId);

    User findByUsername(String username);

    List<User> findAllUsers();

    List<BankAccount> findAllBankAccounts();
}
