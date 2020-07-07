import { Component, OnInit, Input } from '@angular/core';
import { CombustivelListDadService } from './combustivel-list-dad.service';

@Component({
  selector: 'app-combustivel-list-dad',
  templateUrl: './combustivel-list-dad.component.html',
  styleUrls: ['./combustivel-list-dad.component.css']
})
export class CombustivelListDadComponent implements OnInit {

@Input() title : string = 'dados agrupados por distribuidora';
 
dad: Array<any>;

constructor(private combustivelList: CombustivelListDadService) { }

  ngOnInit(): void {
    this.listar();
  }

  listar() {
    this.combustivelList.listar()
        .subscribe(
          res => {
            this.dad = res;
          }
        )
  }

}
