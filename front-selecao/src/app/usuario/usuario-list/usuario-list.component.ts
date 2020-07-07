import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';

import { UsuarioListService } from './usuario-list.service';
import { Usuario } from './usuario';

@Component({
  selector: 'app-usuario-list',
  templateUrl: './usuario-list.component.html',
  styleUrls: ['./usuario-list.component.css']
})
export class UsuarioListComponent implements OnInit, OnDestroy {

  public usuarios: Array<Usuario> = [];
  private subscription: Subscription;

  @Input() title = 'Listar usuarios cadastrados';

  constructor(private usuarioListService: UsuarioListService) { }

  ngOnInit(): void {
    this.event();
    this.listar();
  }

  bla() {
    console.log('lbasd')
  }
  event(){
    this.subscription = this.usuarioListService.notification
      .subscribe(() => {
          this.listar();
        }
      );
  }

  ngOnDestroy(): void
  {
    this.subscription.unsubscribe();
  }

  listar() {
    this.usuarioListService.listar()
      .subscribe(res => {
        this.usuarios = res.content;
      });
  }

  deletar(id: number) {
    this.usuarioListService.deletar(id)
      .subscribe(res => {
        alert('Usuario deletado com sucesso');
        this.listar();
      });
  }

}
