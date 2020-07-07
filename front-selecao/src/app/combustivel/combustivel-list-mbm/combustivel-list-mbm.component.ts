import { Component, OnInit, Input } from '@angular/core';
import { CombustivelListMbmService  } from './combustivel-list-mbm.service'

@Component({
  selector: 'app-combustivel-list-mbm',
  templateUrl: './combustivel-list-mbm.component.html',
  styleUrls: ['./combustivel-list-mbm.component.css']
})
export class CombustivelListMbmComponent implements OnInit {

  public Mbm: Array<any>;

  @Input() title: string = 'média de preço de combustível com base no nome do município';

  constructor(private mbm: CombustivelListMbmService) { }

  ngOnInit(): void {
    this.listar()
  }

  listar() {
    this.mbm.listar()
         .subscribe(
           res=>{
             this.Mbm = res
           }
         )
  }

}
