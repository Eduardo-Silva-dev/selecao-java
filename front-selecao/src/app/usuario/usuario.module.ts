import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import {UsuarioListModule} from './usuario-list/usuario-list.module';
import {CadastroFormModule} from './cadastro-form/cadastro-form.module';
import { UsuarioComponent } from './usuario/usuario.component';






@NgModule({
  imports: [
      CommonModule,
      ReactiveFormsModule,
      HttpClientModule,
      UsuarioListModule,
      CadastroFormModule,
  ],
  declarations: [UsuarioComponent]
})
export class UsuarioModule { }
