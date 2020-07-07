import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {CombustivelFormComponent} from './combustivel-form.component';
import {CardModule} from '../../shared/componentes/card/card.module';



@NgModule({
  declarations: [ CombustivelFormComponent],
  imports: [
    CommonModule,
    CardModule
  ]
})
export class CombustivelFormModule { }
