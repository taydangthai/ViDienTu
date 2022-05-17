import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Observable} from 'rxjs';
import {AuthClass} from '../Models/auth.class';
import {TokenClass} from '../Models/token.class';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  public url_token = 'http://localhost:8011/authenticate';

  constructor(
      public http: HttpClient
  ) { }

  getToken(auth: AuthClass): Observable<String> {
    // @ts-ignore
    return this.http.post(this.url_token, auth);
  }
}
