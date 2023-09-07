import { Injectable } from '@angular/core';
import {AddMoneda, MonedaList} from '../Store/Model/moneda.model';
import {HttpService} from "./http.service";

@Injectable({
  providedIn: 'root'
})
export class MonedaService {

  public monedas: MonedaList[] = [];
  public totalDinero: number = 0;
  public totalMoneda: number = 0;
  constructor(private httpService: HttpService) {

  }

  public getAllDenomination(){
    this.httpService.GetAll().subscribe(value => {
      this.monedas = value;
    })
  }
  public getTotalDinero(){
    this.httpService.Getby('canitdadDinero').subscribe(value => {
      this.totalDinero = value;
    })
  }
  public getTotalMoneda(){
    this.httpService.Getby('canitdadMonedas').subscribe(value => {
      this.totalMoneda = value;
    })
  }
  public Create(moneda: AddMoneda){
    return this.httpService.Create(moneda);
  }

}
