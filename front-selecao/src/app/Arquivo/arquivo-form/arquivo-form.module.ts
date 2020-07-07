import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { ArquivoFormComponent } from './arquivo-form.component';



@NgModule({
  declarations: [ ArquivoFormComponent ],
  imports: [
    CommonModule,
    HttpClientModule
  ]
})
export class ArquivoFormModule { }
