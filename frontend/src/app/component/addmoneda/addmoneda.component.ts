import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder } from "@angular/forms"
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog"
import {AddMoneda} from 'src/app/Store/Model/moneda.model';
import {MonedaService} from "../../service/moneda.service";

@Component({
  selector: 'app-addmoneda',
  templateUrl: './addmoneda.component.html',
  styleUrls: ['./addmoneda.component.css']
})
export class AddmonedaComponent implements OnInit {
  title = 'Insertar moneda'
  dialogdata: any;

  constructor(private builder: FormBuilder, private ref: MatDialogRef<AddmonedaComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any, private monedaService: MonedaService) {

  }
  ngOnInit(): void {
    this.dialogdata = this.data;
    this.title = this.dialogdata.title;

  }

  ClosePopup() {
    this.ref.close();
  }



  monedaForm = this.builder.group({
    value: this.builder.control(0)
  })

  SaveMoneda() {
    if (this.monedaForm.valid) {
      const _obj: AddMoneda = {
        value: this.monedaForm.value.value as number
      }

      this.monedaService.Create(_obj).subscribe(_ => {
        this.monedaService.getAllDenomination();
        this.monedaService.getTotalMoneda();
        this.monedaService.getTotalDinero();
        this.ClosePopup();

      });
    }
  }

}
