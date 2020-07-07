import { Component, OnInit, Input } from '@angular/core';
import { CombustivelListDacService } from './combustivel-list-dac.service';

@Component({
  selector: 'app-combustivel-list-dac',
  templateUrl: './combustivel-list-dac.component.html',
  styleUrls: ['./combustivel-list-dac.component.css']
})
export class CombustivelListDacComponent implements OnInit {

  @Input() title : string = 'dados agrupados pela data da coleta';
 
  dac: Array<any>;
  
  constructor(private combustivelList: CombustivelListDacService) { }
  
    ngOnInit(): void {
      this.listar();
    }
  
    listar() {
      this.combustivelList.listar()
          .subscribe(
            res => {
              this.dac = res;
            }
          )
    }
  
  }