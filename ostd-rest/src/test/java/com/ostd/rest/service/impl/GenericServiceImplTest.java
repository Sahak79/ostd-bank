package com.ostd.rest.service.impl;

import com.ostd.config.BasicTestConfig;
import com.ostd.rest.domain.BankAccount;
import com.ostd.rest.service.GenericService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class GenericServiceImplTest extends BasicTestConfig {

    private static final Long BANK_ACCOUNT = 331345671422l;
    private static final String BANK = "TEST_BANK";
    private static final Long BIC = 5642422l;
    private static final String IBAN = "KL42 1020 0128 0010 0012 0052 7635";

    @Autowired
    private GenericService genericService;

    @Test
    public void addBankAccount() {

        BankAccount bankAccount = new BankAccount();

        bankAccount.setAccount(BANK_ACCOUNT);
        bankAccount.setBank(BANK);
        bankAccount.setBic(BIC);
        bankAccount.setIban(IBAN);

        BankAccount savedBankAccount = genericService.addBankAccount(bankAccount);

        assertNotNull(savedBankAccount);
        assertEquals(BANK_ACCOUNT, savedBankAccount.getAccount());
        assertEquals(BANK, savedBankAccount.getBank());
        assertEquals(BIC, savedBankAccount.getBic());
        assertEquals(IBAN, savedBankAccount.getIban());

    }
}