import { Component, OnInit, Input } from '@angular/core';
import { CombustivelListMvcbService } from './combustivel-list-mvcb.service';

@Component({
  selector: 'app-combustivel-list-mvcb',
  templateUrl: './combustivel-list-mvcb.component.html',
  styleUrls: ['./combustivel-list-mvcb.component.css']
})
export class CombustivelListMvcbComponent implements OnInit {

  @Input() title : string = 'informações importadas por sigla da região';
 
  mvcb: Array<any>;
  
  constructor(private combustivelList: CombustivelListMvcbService) { }
  
    ngOnInit(): void {
      this.listar();
    }
  
    listar() {
      this.combustivelList.listar()
          .subscribe(
            res => {
              this.mvcb = res;
            }
          )
    }
  
  }