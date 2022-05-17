import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app.routing';
import { ComponentsModule } from './components/components.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { AgmCoreModule } from '@agm/core';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { UsersComponent } from './QLCT/users/users.component';
import { TransactionsComponent } from './QLCT/transactions/transactions.component';
import { CategoryComponent } from './QLCT/category/category.component';
import { WalletComponent } from './QLCT/wallet/wallet.component';
import { SignUpComponent } from './QLCT/sign-up/sign-up.component';
import { LogInComponent } from './QLCT/log-in/log-in.component';
import { ForgotPassWordComponent } from './QLCT/forgot-pass-word/forgot-pass-word.component';
import { MatTooltipModule } from '@angular/material/tooltip';

@NgModule({
    imports: [
        BrowserAnimationsModule,
        FormsModule,
        ReactiveFormsModule,
        HttpModule,
        ComponentsModule,
        RouterModule,
        AppRoutingModule,
        HttpClientModule,
        AgmCoreModule.forRoot({
            apiKey: 'YOUR_GOOGLE_MAPS_API_KEY'
        }),
        MatTooltipModule
    ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    UsersComponent,
    TransactionsComponent,
    CategoryComponent,
    WalletComponent,
    SignUpComponent,
    LogInComponent,
    ForgotPassWordComponent,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
