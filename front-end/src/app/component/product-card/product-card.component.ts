import { Component, Input, OnInit } from '@angular/core';
import { Inventario } from 'src/app/model/inventario';
import { Producto } from 'src/app/model/producto';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent implements OnInit {

  @Input()
  inventario!: Inventario;

  constructor() { }

  ngOnInit(): void {
  }

}
