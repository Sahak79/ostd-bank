import {Component, OnInit} from '@angular/core';

import {AppDataService} from '../services/app-data.service';
import {BankAccount} from "../model/bank.account";
import {NgForm} from "@angular/forms";
import {Modal} from "../modal/custom.modal.component";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  accounts: Array<BankAccount> = Array();
  model: BankAccount = new BankAccount();
  edit_model: BankAccount = new BankAccount();
  loading = false;
  error = '';
  success = '';

  constructor(private appDataService: AppDataService) {
  }

  ngOnInit() {
    this.accounts = this.appDataService.getAccounts();
  }

  addBankAccount(form: NgForm) {
    this.loading = true;
    this.appDataService.addBankAccount(this.model)
      .subscribe(
        result => {
          this.loading = false;

          if (result) {
            this.accounts.push(result);
            form.resetForm();
          } else {
            this.error = 'Something went wrong';
          }
        },
        error => {
          this.error = 'Something went wrong';
          this.loading = false;
        }
      );
  }

  openEditModal(editModal: Modal, bank_account: BankAccount) {
    this.success = '';
    UserComponent.mapBankAccount(bank_account, this.edit_model);
    editModal.show(bank_account);
  }

  static mapBankAccount(from: BankAccount, to: BankAccount) {
    to.id = from.id;
    to.account = from.account;
    to.bank = from.bank;
    to.bic = from.bic;
    to.iban = from.iban;
  }

  editBankAccount(editModal: Modal) {
    this.success = '';
    this.loading = true;
    this.edit_model.id = editModal.bank_account.id;
    this.appDataService.editBankAccount(this.edit_model)
      .subscribe(result => {
        this.loading = false;

        if (result) {
          let index = this.accounts.indexOf(editModal.bank_account);
          this.accounts[index] = result;
          editModal.bank_account = result;
          this.success = 'Successfully updated!'
        } else {
          this.error = 'Something went wrong';
        }
      });
  }

  deleteBankAccount(account: BankAccount) {
    this.loading = true;
    this.appDataService.deleteBankAccount(account)
      .subscribe(result => {
        this.loading = false;

        if (result) {
          this.accounts.splice(this.accounts.indexOf(account), 1);
        } else {
          this.error = 'Something went wrong';
        }
      });
  }
}
