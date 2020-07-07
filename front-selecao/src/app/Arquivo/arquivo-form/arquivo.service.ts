import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders, HttpErrorResponse } from '@angular/common/http';

const Api = 'http://localhost:8080/arquivo/';

@Injectable({
  providedIn: 'root'
})
export class ArquivoService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(private http: HttpClient) { }

  salvar(file: File, id: number, nomeArquivo) {
    const formData = new FormData();
    formData.append('file', file);
    return this.http.post(Api +  id  + '/' + nomeArquivo, formData,
      { observe: 'events', reportProgress: true});

  }
}
