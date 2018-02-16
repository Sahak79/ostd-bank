package com.ostd.rest.service.impl;

import com.ostd.rest.domain.BankAccount;
import com.ostd.rest.domain.User;
import com.ostd.rest.repository.BankAccountRepository;
import com.ostd.rest.repository.UserRepository;
import com.ostd.rest.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericServiceImpl implements GenericService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public BankAccount addBankAccount(BankAccount bankAccount) {

        LOGGER.info(String.format("addBankAccount :: %s", bankAccount));

        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public User findByUsername(String username) {

        LOGGER.info(String.format("findByUsername :: %s", username));

        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {

        LOGGER.info("findAllUsers");

        return (List<User>)userRepository.findAll();
    }

    @Override
    public List<BankAccount> findAllBankAccounts() {

        LOGGER.info("findAllBankAccounts");

        return (List<BankAccount>) bankAccountRepository.findAll();
    }
}
