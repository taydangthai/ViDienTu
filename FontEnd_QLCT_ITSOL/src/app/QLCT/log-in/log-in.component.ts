import {Component, OnInit} from '@angular/core';
import {AuthClass} from '../../Models/auth.class';
import {TokenService} from '../../Service/token.service';
import {Subscription} from 'rxjs';
import {Router} from '@angular/router';
import { UsersService } from '../../Service/users.service';

@Component({
    selector: 'app-log-in',
    templateUrl: './log-in.component.html',
    styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

    public err = 0;
    public errCheck = 0;
    public userName: string;
    public passWord: string;
    public subscription: Subscription;
    public token: string;

    public id: number;

    constructor(
        public tokenService: TokenService,
        public router: Router,
        public usersService: UsersService
    ) {
    }

    ngOnInit(): void {
    }

    login() {
        // tslint:disable-next-line:triple-equals o => o.title.toLowerCase().contains(this.state.query.toLowerCase())
        // if (this.checkLogin() != -1 && this.checkLogin() != -2) {
        const infoAcc = new AuthClass(this.userName, this.passWord);
        this.subscription = this.tokenService.getToken(infoAcc).subscribe(data => {
            localStorage.setItem('token', JSON.stringify(data));
            this.getUserId(this.userName, this.passWord);

            window.location.replace('/#/wallet');
        }, error => {
            this.err = -1;
            // console.log(error);
        });

    }

    // lay theo id(get post put delete)
    private getUserId(userName: string, passWord: string) {
        this.subscription = this.usersService.getIdByUserNamePassWord(userName, passWord).subscribe(data => {
            // @ts-ignore
            localStorage.setItem('userid', JSON.stringify(data));
            // console.log(data);
        }, error => {
            // console.log(error);
        });
    }

    checkLogin() {
        // tslint:disable-next-line:triple-equals
        if (this.userName == null || this.userName == '') {
            return this.errCheck = -1;
        }
        // tslint:disable-next-line:triple-equals
        if (this.passWord == null || this.passWord == '') {
            return this.errCheck = -2;
        }
    }

}
