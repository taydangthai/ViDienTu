import { Routes } from '@angular/router';

import { DashboardComponent } from '../../trangchu/dashboard.component';
import {CategoryComponent} from '../../QLCT/category/category.component';
import {TransactionsComponent} from '../../QLCT/transactions/transactions.component';
import {WalletComponent} from '../../QLCT/wallet/wallet.component';


export const AdminLayoutRoutes: Routes = [
    { path: 'home',           component: DashboardComponent },
    { path: 'category',       component: CategoryComponent},
    { path: 'transactions',   component: TransactionsComponent},
    { path: 'wallet',         component: WalletComponent},
];
