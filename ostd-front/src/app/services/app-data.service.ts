import {Injectable} from '@angular/core';
import {AuthHttp} from 'angular2-jwt';
import {BankAccount} from '../model/bank.account';

@Injectable()
export class AppDataService {
  private data;
  constructor(private http: AuthHttp) {
  }

  addBankAccount(account: BankAccount) {
    return this.http.post('/springjwt/accounts', account).map(res => res.json());
  }

  editBankAccount(account: BankAccount) {
    return this.http.put('/springjwt/accounts', account).map(res => res.json());
  }

  deleteBankAccount(account: BankAccount) {
    return this.http.delete('/springjwt/accounts/' + account.id).map(res => res.json());
  }

  getAccounts() {
    this.data = [];
    this.http.get('/springjwt/accounts').subscribe(res => {
      this.data.push(...res.json());
    });
    return this.data;
  }

  getUsers() {
    return this.http.get('/springjwt/users').map(res => res.json());
  }
}
