import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MonedalistingComponent } from './component/monedalisting/monedalisting.component';

const routes: Routes = [
  {path:'',component:MonedalistingComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
