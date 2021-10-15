import { Component, Input, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { Inventario } from 'src/app/model/inventario';
import { InventarioService } from 'src/app/service/inventario/inventario.service';
import { ProductService } from 'src/app/service/product/product.service';
import { UtilModal } from 'src/app/util/util-modal';

@Component({
  selector: 'app-product-home',
  templateUrl: './product-home.component.html',
  styleUrls: ['./product-home.component.css']
})
export class ProductHomeComponent implements OnInit {

  @Input() inventario!: Inventario;
  isNew!: boolean;
  isDecrease = false;
  quantity = new FormControl(0);

  constructor(private inventarioService: InventarioService, private router: Router) { }

  ngOnInit(): void {
    if (this.inventarioService.inventario) {
      this.inventario = this.inventarioService.inventario;
    } else {
      this.inventario = this.inventarioService.getDefaultInventario();
    }
  }

  addQuantity(): void {
    this.inventario.cantidad += this.quantity.value;
    this.inventarioService.update(this.inventarioService.buildComandoInventarioToUpdate(this.inventario)).toPromise().then(idInventario => {
      if(this.inventario.idInventario === idInventario){
        //mostrarAlerta
        this.inventarioService.changeInventario(this.inventarioService.inventario, this.inventario);
        console.log(idInventario);
      }
    }).catch(error => console.log(error));
  }

  decreaseQuantity(): void {
    if (this.inventario.cantidad >= this.quantity.value) {
      this.inventario.cantidad -= this.quantity.value;
      this.inventarioService.update(this.inventarioService.buildComandoInventarioToUpdate(this.inventario)).toPromise().then(idInventario => {
        if(this.inventario.idInventario === idInventario){
          //mostrarAlerta
          this.inventarioService.changeInventario(this.inventarioService.inventario, this.inventario);
          console.log(idInventario);
        }
      }).catch(error => console.log(error));
      this.isDecrease = false;
    } else {
      this.isDecrease = true;
    }
  }

  delete(): void {
    this.inventarioService.delete(this.inventario.idInventario).toPromise().then(idInventario=>{
      this.inventarioService.removeInventario(this.inventario);
      console.log(idInventario)
    }).catch(error=>console.log(error));
    this.router.navigate(['/home']);
  }

  showModal(show: boolean, id: string): void {
    UtilModal.show(show, id);
  }

  setIsNew(isNew: boolean): void {
    this.isNew = isNew;
  }

}
