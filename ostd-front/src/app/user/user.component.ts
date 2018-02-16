import {Component, OnInit} from '@angular/core';

import {AppDataService} from '../services/app-data.service';
import {BankAccount} from "../model/bank.account";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  accounts: Array<BankAccount> = Array();
  model: BankAccount = new BankAccount();
  loading = false;
  error = '';

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
}
