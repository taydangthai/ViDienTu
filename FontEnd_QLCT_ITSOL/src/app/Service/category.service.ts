import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CategoryGetDeleteClass} from '../Models/Category/CategoryGetDelete.class';
import {CategoryPostPutClass} from '../Models/Category/CategoryPostPut.class';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  // tslint:disable-next-line:variable-name
  public url_c_get1 = 'http://localhost:8011/category/showAll';
  // tslint:disable-next-line:variable-name
  public url_c_post = 'http://localhost:8011/category/add';
  // tslint:disable-next-line:variable-name
  public url_c_delete = 'http://localhost:8011/category/deleteId/';

  public delete: string;

  heardrs = {
    'Content-Type': 'application/json',
    Accept: 'application/json',
    'Access-Controll-Allow-Headers': 'Content-Type'
  };

  constructor(
    public httpClient: HttpClient
  ) { }

  getCategory(): Observable<CategoryGetDeleteClass[]>
  {
    // @ts-ignore
    return this.httpClient.get(this.url_c_get1, this.heardrs);
  }

  postCategory(categoryClass: CategoryPostPutClass): Observable<CategoryGetDeleteClass>{
    // @ts-ignore
    return this.httpClient.post(this.url_c_post, categoryClass);
  }

  // tslint:disable-next-line:typedef
  // @ts-ignore
  deleteCategory(categoryClass: CategoryGetDeleteClass): Observable<CategoryGetDeleteClass>{

    this.delete = this.url_c_delete + categoryClass.categoryId;
    console.log(this.url_c_delete);
    // @ts-ignore
    return this.httpClient.delete(this.delete);
  }
}
