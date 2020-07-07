import { Component, OnInit, Input } from '@angular/core';
import { CombustivelListMvvmService } from './combustivel-list-mvvm.service';

@Component({
  selector: 'app-combustivel-list-mvvm',
  templateUrl: './combustivel-list-mvvm.component.html',
  styleUrls: ['./combustivel-list-mvvm.component.css']
})
export class CombustivelListMvvmComponent implements OnInit {

  @Input() title : string = 'informações importadas por sigla da região';
 
  mvvm: Array<any>;
  
  constructor(private combustivelList: CombustivelListMvvmService) { }
  
    ngOnInit(): void {
      this.listar();
    }
  
    listar() {
      this.combustivelList.listar()
          .subscribe(
            res => {
              this.mvvm = res;
            }
          )
    }
  
  }