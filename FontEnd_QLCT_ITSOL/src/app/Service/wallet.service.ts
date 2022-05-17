import {Injectable, OnDestroy, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, Subscription} from 'rxjs';
import {WalletGDClass} from '../Models/Wallet/WalletGD.class';
import { WalletPPClass} from '../Models/Wallet/WalletPP.class';


@Injectable({
  providedIn: 'root'
})
export class WalletService {

  // tslint:disable-next-line:variable-name
  public url_w_get1 = 'http://localhost:8011/wallet/showAll';
  // get theo id
  public url_uw_get1 = 'http://localhost:8011/UserWallet/find/' + localStorage.getItem('userid');
  // tslint:disable-next-line:variable-name
  public url_w_post = 'http://localhost:8011/wallet/add';
  // tslint:disable-next-line:variable-name
  public url_w_delete = 'http://localhost:8011/wallet/deleteId/';

  private delete: string;
  private tmp: string;

  public httpOption = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.getToken(),
    })
  }

  constructor(
      public httpClient: HttpClient
  ) { }

  getFindByUserId(itemWallet: WalletGDClass): Observable<WalletGDClass> {
    // @ts-ignore
    return this.httpClient.get(this.url_uw_get1, this.httpOption);
  }
  // post
  postWallet(walletClass: WalletPPClass): Observable<string> {
    // @ts-ignore
    return this.httpClient.post(this.url_w_post, walletClass, this.httpOption);
  }

  deleteWalletId(walletDelete: WalletGDClass): Observable<any> {

    this.delete = this.url_w_delete + walletDelete.walletId;
    console.log(this.url_w_delete);
    // @ts-ignore
    return this.httpClient.delete(this.delete);
  }

  handleErrorResponse(error) {
    if (error.error instanceof Error) {
      console.log('client: ' + error.error);
    } else {
      console.log('server: ' + error.error + ' _ ' + error.error.text);
      return error.error.text;
    }
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
