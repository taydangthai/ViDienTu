import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from 'rxjs';
import {WalletGDClass} from '../../Models/Wallet/WalletGD.class';
import { WalletService } from '../../Service/wallet.service';
import {WalletPPClass} from '../../Models/Wallet/WalletPP.class';
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit, OnDestroy {

  public subscription: Subscription;
  public walletGDClass: WalletGDClass[];
  public itemWallet: WalletGDClass;

  public walletId: number;
  public walletName: string;
  public balance: number;
  public currency = 0;
  public createDate: string;
  public userId: number;


  constructor(
      public walletService: WalletService
  ) { }

  ngOnInit(): void {
    this.showAllByUserId();
  }

  showAllByUserId() {
    // @ts-ignore
    this.subscription = this.walletService.getFindByUserId(this.itemWallet).subscribe(data => {
      // @ts-ignore
      this.walletGDClass = data;
      console.log(data);
    }, error => {
      console.log(error);
    });
  }

  configRemove(walletGDClass2: WalletGDClass) {
    this.itemWallet = walletGDClass2;
  }

  removeWalletById(walletGDClass: WalletGDClass) {
    // @ts-ignore
    this.subscription = this.walletService.deleteWalletId(walletGDClass).subscribe(data => {
      // @ts-ignore
      this.walletGDClass = data;
      console.log(data);
    }, error => {
      console.log(error);
    });

    window.location.reload();
  }

  addWallet() {

    this.checkNull();
    // @ts-ignore
    this.createDate = formatDate(new Date(), 'YYYY-MM-dd', 'en-US', '+0530').substring(0, 10);
    console.log(this.createDate);
    const walletPPClass: WalletPPClass = new WalletPPClass(0, this.walletName, this.balance, this.currency, this.createDate, this.userId);
    // @ts-ignore
    this.subscription = this.walletService.postWallet(walletPPClass).subscribe(data => {
      // @ts-ignore
      this.walletGDClass = data;
      console.log(data);
    }, error => {
      console.log(error);
      const temp: string = this.walletService.handleErrorResponse(error);
      this.checkExit(temp);
    });

    // window.location.reload();
  }

  checkExit(walletName: string) {
    // tslint:disable-next-line:triple-equals
    if (walletName == this.walletName) {
      alert('Ten vi da ton tai');
      // tslint:disable-next-line:triple-equals
    } else if (walletName == 'success') {
      window.location.reload();
    } else {
      alert('loi may chu');
      window.location.reload();
    }
  }

  checkNull() {
    if (this.walletName == null) { alert('Hay Nhap Ten Vi'); }
    if (this.balance == null) { alert('Hay Nhap So Tien'); }
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      return this.subscription.unsubscribe()
    }
  }

}
