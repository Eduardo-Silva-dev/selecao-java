import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';

import { Usuario } from '../usuario-list/usuario';
import { CadastroFormService } from './cadastro-form.service';
import { UsuarioListService } from '../usuario-list/usuario-list.service';

@Component({
  selector: 'app-cadastro-form',
  templateUrl: './cadastro-form.component.html',
  styleUrls: ['./cadastro-form.component.css']
})
export class CadastroFormComponent implements OnInit {

  private subscription: Subscription;
   @Input() title: string = 'cadastrar usuario';
   CadastroUsuario: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private  cadastroFormService: CadastroFormService,
              private usualListService: UsuarioListService) { }

  ngOnInit(): void {

    this.CadastroUsuario = this.formBuilder.group({
      nome: ['',
        [
          Validators.required,
          Validators.minLength(2)
        ]
      ],
      sobrenome: ['',
        [
        Validators.required,
        Validators.minLength(2)
        ]
      ],
      cpf: ['',
        [
        Validators.required,
        Validators.minLength(11),
        Validators.maxLength(11)
        ]
      ]
    });
  }

  salvar(){
    const  usuario = this.CadastroUsuario.getRawValue() as Usuario;
    this.cadastroFormService
         .salvar(usuario)
         .subscribe(
           res => {
             alert('Usuario cadastrado com sucesso');
           this.usualListService.notification.emit();
           }
         );
  }

}
