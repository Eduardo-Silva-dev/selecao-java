import { EventEmitter, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from './usuario';
import { Observable, throwError } from 'rxjs';

const api = 'http://localhost:8080/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioListService {

  public notification: EventEmitter<void> = new EventEmitter();

  constructor(private http: HttpClient) { }

  listar(): Observable<Usuario> {
    return this.http.get<Usuario>(api);
  }

  deletar(id: number) {
    return this.http.delete(api + '/' + id);
  }

}
