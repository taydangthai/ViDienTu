import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UsersGetDeleteClass} from '../Models/Users/UsersGetDelete.class';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  // tslint:disable-next-line:variable-name
  public url_u_get1 = 'http://localhost:8011/users/showAllExceptPass';
  // tslint:disable-next-line:variable-name
  public url_u_post = 'http://localhost:8011/users/add';
  // tslint:disable-next-line:variable-name
  public url_u_delete = 'http://localhost:8011/users/deleteId/';

  public url_u_id = 'http://localhost:8011/user/id';

  private delete: string;
  private tmp: string;

  public httpOption = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer '/* + this.getToken(),*/
    })
  }

  constructor(
    public httpClient: HttpClient
  ) { }

  getIdByUserNamePassWord(userName: string, passWord: string): Observable<number> {
    this.url_u_id = this.url_u_id + '?userName=' + userName + '&passWord=' + passWord;
    // @ts-ignore
    return this.httpClient.get(this.url_u_id, this.httpOption);
  }

  getUsersExceptPass(): Observable<UsersGetDeleteClass[]> {
    // @ts-ignore
    return this.httpClient.get(this.url_u_get1, this.httpOption);
  }
  // postUsers(usersService: UsersService): Observable<Users>

  deleteUsers(usersClass: UsersGetDeleteClass): Observable<UsersGetDeleteClass> {
    this.delete = this.url_u_delete + usersClass.userId;
    // @ts-ignore
    return this.httpClient.delete(this.delete);
  }

  // getToken(): string {
  //   const token = localStorage.getItem('token');
  //   JSON.parse(JSON.stringify(token), (key, value) => {
  //     value = value.toString().replace('\{\"token\"\:\"', '');
  //     value = value.toString().replace('\"\}', '');
  //     this.tmp = value;
  //     console.log(this.tmp);
  //   });
  //   return this.tmp;
  // }
}
