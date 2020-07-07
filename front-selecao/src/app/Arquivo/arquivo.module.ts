import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule} from '@angular/forms';

import { ArquivoFormComponent } from './arquivo-form/arquivo-form.component';
import {CardModule} from '../shared/componentes/card/card.module';


@NgModule({
  declarations: [ ArquivoFormComponent ],
  exports: [ ArquivoFormComponent ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    CardModule
  ]
})
export class ArquivoModule { }
