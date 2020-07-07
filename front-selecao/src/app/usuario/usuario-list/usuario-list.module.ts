import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {UsuarioListComponent} from './usuario-list.component';
import {CardModule} from '../../shared/componentes/card/card.module';
import {AppRoutingModule} from '../../app-routing.module';



@NgModule({
  declarations: [UsuarioListComponent],
  exports: [
    UsuarioListComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    CardModule
  ]
})
export class UsuarioListModule { }
