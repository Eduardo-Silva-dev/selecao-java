import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ReactiveFormsModule} from '@angular/forms';

import { CadastroFormComponent } from './cadastro-form.component';
import { CardModule } from '../../shared/componentes/card/card.module';




@NgModule({
  declarations: [CadastroFormComponent],
  exports: [
    CadastroFormComponent
  ],
  imports: [
    CommonModule,
    CardModule,
    ReactiveFormsModule
  ]
})
export class CadastroFormModule { }
