import { Component, Input, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Inventario } from 'src/app/model/inventario';
import { InventarioService } from 'src/app/service/inventario/inventario.service';
import { UtilModal } from 'src/app/util/util-modal';
import Swal from 'sweetalert2';

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
    const inventarioToUpdate = this.inventarioService.buildComandoInventarioToUpdate(this.inventario);
    inventarioToUpdate.cantidad += this.quantity.value;
    this.inventarioService.update(inventarioToUpdate).toPromise().then(idInventario => {
      console.log(idInventario);
      if (this.inventario.idInventario === idInventario.valor) {
        this.inventario.cantidad += this.quantity.value;
        this.inventarioService.changeInventario(this.inventarioService.inventario, this.inventario);
        Swal.fire('Cantidad del producto aumentada exitosamente');
      }
    }).catch(error => {
      console.log(error);
      Swal.fire('Ha ocurrido un problema por lo que no se pudo aumentar la cantidad del producto');
    });
  }

  decreaseQuantity(): void {
    if (this.inventario.cantidad >= this.quantity.value) {
      const inventarioToUpdate = this.inventarioService.buildComandoInventarioToUpdate(this.inventario);
      inventarioToUpdate.cantidad -= this.quantity.value;
      this.inventarioService.update(inventarioToUpdate).toPromise().then(idInventario => {
        if (this.inventario.idInventario === idInventario.valor) {
          this.inventario.cantidad -= this.quantity.value;
          this.inventarioService.changeInventario(this.inventarioService.inventario, this.inventario);
          console.log(idInventario);
          Swal.fire('Cantidad del producto disminuida exitosamente');
        }
      }).catch(error => {
        console.log(error);
        Swal.fire('Ha ocurrido un problema por lo que no se pudo disminuir la cantidad del producto');
      });
      this.isDecrease = false;
    } else {
      this.isDecrease = true;
    }
  }

  delete(): void {
    this.inventarioService.delete(this.inventario.idInventario).toPromise().then(idInventario => {
      console.log(this.inventario.idInventario, idInventario, this.inventario.idInventario === idInventario.valor);
      if (this.inventario.idInventario === idInventario.valor) {
        this.inventarioService.removeInventario(this.inventario);
        Swal.fire('Producto ha sido eliminado del inventario correctamente');
        this.router.navigate(['/home']);
      }
    }).catch(error => {
      console.log(error);
      Swal.fire('Ha ocurrido un problema por lo que no se pudo eliminar el producto del inventario');
    });
  }

  showModal(show: boolean, id: string): void {
    UtilModal.show(show, id);
  }

  getInventario(inventario: Inventario): void {
    this.inventario = inventario;
    console.log('getInventario',inventario);
  }

  setIsNew(isNew: boolean): void {
    this.isNew = isNew;
  }

}
