import { Injectable, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../usuario-list/usuario';


const Api = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class CadastroFormService {



  constructor(private http: HttpClient) { }

  salvar(usuario: Usuario) {
    console.log(usuario);
    return this.http.post(Api + '/usuario', usuario);
  }

}
