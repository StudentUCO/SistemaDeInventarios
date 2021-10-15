import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Inventario } from 'src/app/model/inventario';
import { Producto } from 'src/app/model/producto';
import { InventarioService } from 'src/app/service/inventario/inventario.service';
import { ProductService } from 'src/app/service/product/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  inventarioList!: Inventario[];

  constructor(private inventarioService: InventarioService) { }

  ngOnInit(): void {
    this.inventarioService.getAll().toPromise().then(list => {
      this.inventarioList = list;
      this.inventarioService.changeInventarioList(list);
    }).catch(error=>console.log(error));
    this.inventarioService.customInventarioList.subscribe(list => this.inventarioList = list);
  }

  setInventario(inventario: Inventario) {
    this.inventarioService.inventario = inventario;
  }

}
