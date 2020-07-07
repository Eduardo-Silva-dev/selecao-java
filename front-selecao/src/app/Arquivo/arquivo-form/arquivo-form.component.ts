import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpEvent, HttpEventType } from '@angular/common/http';
import { ArquivoService } from './arquivo.service';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-arquivo-form',
  templateUrl: './arquivo-form.component.html',
  styleUrls: ['./arquivo-form.component.css']
})
export class ArquivoFormComponent implements OnInit {

  @Input() title: string = 'Inserir Planilha';
  file: File;
  progress = 0;
  arquivoForm: FormGroup;
  id: number;

  constructor(private formBuilder: FormBuilder,
              private arquivoService: ArquivoService,
              private route: ActivatedRoute,
              private router: Router
             ) { }

  ngOnInit(): void {
    this.arquivoForm = this.formBuilder.group({
      nomeArquivo: ['', Validators.required],
      file: ['', Validators.required]
    });
  }

  salvar(){
   let nomeArquivo = this.arquivoForm.get('nomeArquivo').value;
   this.id =  this.route.snapshot.params['id'];
   this.arquivoService.salvar(this.file, this.id, nomeArquivo)
     .subscribe((event: HttpEvent<object>) => {
       if (event.type === HttpEventType.Response) {
         alert("Upload concluido")
           this.arquivoForm.reset('nomeArquivo');
       } else if (event.type === HttpEventType.UploadProgress) {
         const percentDone = Math.round((event.loaded * 100) / event.total);
         this.progress = percentDone;
       }
     },
       error => {
       console.log('erro ao fazer o upload ' + error);
       })
  }

}
