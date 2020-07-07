import { Component, OnInit, Input } from '@angular/core';
import { CombustivelListIsrService } from './combustivel-list-isr.service';

@Component({
  selector: 'app-combustivel-list-isr',
  templateUrl: './combustivel-list-isr.component.html',
  styleUrls: ['./combustivel-list-isr.component.css']
})

export class CombustivelListIsrComponent implements OnInit {

  @Input() title : string = 'informações importadas por sigla da região';
 
  isr: Array<any>;
  
  constructor(private combustivelList: CombustivelListIsrService) { }
  
    ngOnInit(): void {
      this.listar();
    }
  
    listar() {
      this.combustivelList.listar()
          .subscribe(
            res => {
              this.isr = res;
            }
          )
    }
  
  }