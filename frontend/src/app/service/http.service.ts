import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {AddMoneda, MonedaList} from '../Store/Model/moneda.model';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  baseurl = 'http://localhost:8080/money';
  constructor(private http: HttpClient) {

  }

  GetAll() {
    return this.http.get<MonedaList[]>(this.baseurl + '/' + 'groupByValue');
  }

  Getby(code: string) {
    return this.http.get<number>(this.baseurl + '/' + code);
  }
  Delete(code: number) {
    return this.http.delete(this.baseurl + '/' + code);
  }
  Create(data: AddMoneda) {
    return this.http.post(this.baseurl + '/', data);
  }
}
