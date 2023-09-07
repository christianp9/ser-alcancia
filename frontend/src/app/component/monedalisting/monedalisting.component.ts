import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from "@angular/material/dialog"
import { AddmonedaComponent } from '../addmoneda/addmoneda.component';
import { MatPaginator } from "@angular/material/paginator"
import { MatSort } from "@angular/material/sort"
import {MonedaService} from "../../service/moneda.service";

@Component({
  selector: 'app-monedalisting',
  templateUrl: './monedalisting.component.html',
  styleUrls: ['./monedalisting.component.css']
})
export class MonedalistingComponent implements OnInit {

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  displayedColums: string[] = ["denomination", "quantity", "moneyByDenomination" ]
  constructor(private dialog: MatDialog, public monedaService: MonedaService) {

  }
  ngOnInit(): void {
    this.monedaService.getAllDenomination();
    this.monedaService.getTotalMoneda();
    this.monedaService.getTotalDinero();

  }

  functionAdd() {
    this.openPopupAdd(0, 'Insertar moneda');
  }


  openPopupAdd(code: number, title: string) {
    this.dialog.open(AddmonedaComponent, {
      width: '50%',
      enterAnimationDuration: '1000ms',
      exitAnimationDuration: '1000ms',
      data: {
        code: code,
        title: title
      }
    })

  }


}
