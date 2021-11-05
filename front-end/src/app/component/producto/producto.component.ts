import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Producto } from 'src/app/model/producto';
import { ProductService } from 'src/app/service/product/product.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css']
})
export class ProductoComponent implements OnInit {

  productList!: Producto[];
  product!: Producto;
  productoEdicion!: Producto;
  form!: FormGroup;
  constructor(private productService: ProductService,private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.getListProducts();
    this.buildForm();
  }
  getListProducts(){
    this.productService.getProductList().toPromise().then(list => this.productList = list).catch(error => console.log(error));
  }
  onCrear(){
    this.guardar();
  }
  buildForm(): void {
    this.form = this.formBuilder.group({
        idProducto:0,
        nombre: 'default',
        codigo: '#####',
        activo: true
     
    });
  }
  buildFormEdicion(): void {
    this.form = this.formBuilder.group({
        idProducto:this.productoEdicion.idProducto,
        nombre: this.productoEdicion.nombre,
        codigo: this.productoEdicion.codigo,
        activo: this.productoEdicion.activo
     
    });
  }

  

  delete(product:Producto): void {
    this.productService.delete(product.idProducto).toPromise().then(idProducto => {
      Swal.fire('Producto ha sido eliminado del inventario correctamente');
      this.getListProducts();
    }).catch(error => {
      console.log(error);
      Swal.fire('Ha ocurrido un problema por lo que no se pudo eliminar el producto del inventario');
    });
    this.ngOnInit();
  }

  guardar(){
    
    const productToCreate = this.productService.buildProduct(this.form.value, this.product);
    console.log(this.product)
    this.productService.create(this.productService.buildProduct(this.form.value, this.product)).toPromise().then(idProducto => {
      this.getListProducts();  
      Swal.fire('Producto adicionado correctamente');
    }).catch(error => {
      console.log(error);
      Swal.fire('Ha ocurrido un problema, por lo que no se pudo adicionar el producto');
    });
  }

  update(): void {
    const inventarioToUpdate = this.productService.buildProduct(this.form.value, this.productoEdicion);
    inventarioToUpdate.idProducto=this.productoEdicion.idProducto;
    this.productService.update(this.productService.buildProduct(inventarioToUpdate)).toPromise().then(idInventario => {
        Swal.fire('Producto ha sido cambiado correctamente');
        this.getListProducts();
    }).catch(error => {
      console.log(error);
      Swal.fire('Ha ocurrido un problema, por lo que no se pudo editar el producto');
    });
  }

  anadirEdicionProducto(producto: Producto){
    this.productoEdicion=producto;
    this.buildFormEdicion()
  
  }
  
  onEditar(){
    this.update();
  }

}
