import { Component, OnInit } from '@angular/core';
import {Subscription} from 'rxjs';
import {TransactionsService} from '../../Service/transactions.service';
import {TransactionsGetDeleteClass} from '../../Models/Transactions/TransactionsGetDelete.class';
import {WalletGDClass} from '../../Models/Wallet/WalletGD.class';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {

  public transactionsGDClass: TransactionsGetDeleteClass[];
  public itemTrans: TransactionsGetDeleteClass;
  constructor(
      public transactionsService: TransactionsService
  ) { }

  ngOnInit(): void {
    this.showAllByUserId();
  }

  showAllByUserId() {
    // @ts-ignore
    this.subscription = this.transactionsService.getTransactionsByUserId(this.itemTrans).subscribe(data => {
      // @ts-ignore
      this.transactionsGDClass = data;
      console.log(data);
    }, error => {
      console.log(error);
    });
  }

  configRemove(trans: TransactionsGetDeleteClass) {
    this.itemTrans = trans;
  }
}
