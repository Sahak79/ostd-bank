package com.ostd.rest.domain;

import javax.persistence.*;

@Entity
@Table(name = "bank_account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account")
    private Long account;

    @Column(name = "iban")
    private String iban;

    @Column(name = "bank")
    private String bank;

    @Column(name = "bic")
    private Long bic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Long getBic() {
        return bic;
    }

    public void setBic(Long bic) {
        this.bic = bic;
    }

    public boolean validate() {
        return account != null && bic != null
                && iban != null && !iban.trim().equals("")
                && bank != null && !bank.trim().equals("");
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", account=" + account +
                ", iban='" + iban + '\'' +
                ", bank='" + bank + '\'' +
                ", bic=" + bic +
                '}';
    }
}
