import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ArquivoFormComponent } from './Arquivo/arquivo-form/arquivo-form.component';
import { UsuarioComponent } from './usuario/usuario/usuario.component';
import {CombustivelListMbmComponent} from './combustivel/combustivel-list-mbm/combustivel-list-mbm.component';
import { CombustivelListDadComponent } from './combustivel/combustivel-list-dad/combustivel-list-dad.component';
import { CombustivelListIsrComponent } from './combustivel/combustivel-list-isr/combustivel-list-isr.component';
import { CombustivelListDacComponent } from './combustivel/combustivel-list-dac/combustivel-list-dac.component';
import { CombustivelListMvvmComponent } from './combustivel/combustivel-list-mvvm/combustivel-list-mvvm.component';
import { CombustivelListMvcbComponent } from './combustivel/combustivel-list-mvcb/combustivel-list-mvcb.component';

const routes: Routes = [
  {
    path: 'index', component: UsuarioComponent,
  },
  {
    path: 'planilha/:id', component: ArquivoFormComponent
  },
  {
    path: 'mediaBase', component: CombustivelListMbmComponent
  },
  {
    path: 'distribuidora', component: CombustivelListDadComponent
  },
  {
    path: 'sigla', component: CombustivelListIsrComponent
  },
  {
    path: 'coleta', component: CombustivelListDacComponent
  },
  {
    path: 'município', component: CombustivelListMvvmComponent
  },
  {
    path: 'bandeira', component: CombustivelListMvcbComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { useHash: true })
  ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
