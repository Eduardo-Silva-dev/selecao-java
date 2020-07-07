import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UsuarioModule } from './usuario/usuario.module';
import { BarraNavegacaoComponent } from './shared/componentes/barra-navegacao/barra-navegacao.component';
import { MenuLateralComponent } from './shared/componentes/barra-navegacao/menu-lateral/menu-lateral.component';

import { AppRoutingModule } from './app-routing.module';
import { ArquivoModule } from './Arquivo/arquivo.module';
import { CombustivelModule } from './combustivel/combustivel.module';
import { SearchComponent } from './shared/componentes/search/search.component';
import { FilterPipe } from './shared/componentes/search/filter.pipe';


@NgModule({
  declarations: [
    AppComponent,
    BarraNavegacaoComponent,
    MenuLateralComponent,
    SearchComponent,
    FilterPipe,

  ],
  imports: [
    BrowserModule,
    UsuarioModule,
    AppRoutingModule,
    ArquivoModule,
    CombustivelModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
