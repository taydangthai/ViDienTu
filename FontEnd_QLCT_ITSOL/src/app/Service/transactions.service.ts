import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TransactionsGetDeleteClass } from '../Models/Transactions/TransactionsGetDelete.class';
import { TransactionsPostPutClass } from '../Models/Transactions/TransactionsPostPut.class';

@Injectable({
  providedIn: 'root'
})
export class TransactionsService {

  // tslint:disable-next-line:variable-name
  public url_t_get1 = 'http://localhost:8011/transactions/showTransByUserId/' + localStorage.getItem('userid');
  // tslint:disable-next-line:variable-name
  public url_t_post = 'http://localhost:8011/transactions/add';
  // tslint:disable-next-line:variable-name
  public url_t_delete = 'http://localhost:8011/transactions/deleteId/';

  private delete: string;
  private tmp: string;

  public httpOption = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.getToken()
    })
  }

  constructor(
    public httpClient: HttpClient
  ) { }

  // get by data time
  getTransactionsByUserId(): Observable<TransactionsGetDeleteClass[]> {

    // @ts-ignore
    return this.httpClient.get(this.url_t_get1, this.httpOption);
  }

  // post add
  postTransactions(transactionsClass: TransactionsPostPutClass): Observable<TransactionsGetDeleteClass> {

    // @ts-ignore
    return this.httpClient.post(this.url_t_post, transactionsClass);
  }

  // delete
  deleteTransactions(transactionsClass: TransactionsGetDeleteClass): Observable<TransactionsGetDeleteClass> {

    this.delete = this.url_t_delete + transactionsClass.transId;
    // @ts-ignore
    return this.httpClient.delete(this.delete);
  }

  getToken(): string {
    const token = localStorage.getItem('token');
    JSON.parse(JSON.stringify(token), (key, value) => {
      value = value.toString().replace('\{\"token\"\:\"', '');
      value = value.toString().replace('\"\}', '');
      this.tmp = value;
      console.log(this.tmp);
    });
    return this.tmp;
  }
}
