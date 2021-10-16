import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Inventario } from 'src/app/model/inventario';
import { Producto } from 'src/app/model/producto';
import { InventarioService } from 'src/app/service/inventario/inventario.service';
import { ProductService } from 'src/app/service/product/product.service';
import { UtilModal } from 'src/app/util/util-modal';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {

  @Input() set setIsNew(isNew: boolean) {
    this.isNew = isNew;
  }
  @Input() inventario!: Inventario;
  @Output() inventarioChange = new EventEmitter<Inventario>();
  /* @Input() set setProduct(product: Product) {
    this.product = product;
    this.buildForm();
    this.form?.patchValue(product);
  };
  product?: Product; */
  isNew!: boolean;
  product!: Producto;
  productList!: Producto[];
  form!: FormGroup;

  constructor(private formBuilder: FormBuilder, private inventarioService: InventarioService, private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.getProductList().toPromise().then(list => this.productList = list).catch(error => console.log(error));
    this.buildForm();
    if (this.inventario) {
      this.product = this.inventario.producto;
      this.form.patchValue(this.inventario);
    } else {
      this.inventario = this.inventarioService.getDefaultInventario();
      this.product = this.productService.getDefaultProduct();
    }
  }

  buildForm(): void {
    this.form = this.formBuilder.group({
      producto: {
        idProducto: 0,
        nombre: 'default',
        codigo: '#####',
        activo: false
      },
      cantidad: 0,
      /* price: [0, ],
      description: ['', ] */
    });
  }

  save(): void {
    if (this.isNew) {
      this.create();
    } else {
      this.update();
    }
    this.showModal(false, 'product-form');
  }

  create(): void {
    const inventarioToCreate = this.inventarioService.buildInventario(this.form.value, this.inventario);
    this.inventarioService.create(this.inventarioService.buildComandoInventarioToCreate(inventarioToCreate)).toPromise().then(idInventario => {
      this.inventario = inventarioToCreate;
      this.inventario.idInventario = idInventario.valor
      this.inventarioService.addInventario(this.inventario);
      this.inventarioChange.emit(this.inventario);
      Swal.fire('Producto adicionado al inventario correctamente');
    }).catch(error => {
      console.log(error);
      Swal.fire('Ha ocurrido un problema, por lo que no se pudo adicionar un producto al inventario');
    });
  }

  update(): void {
    const inventarioToUpdate = this.inventarioService.buildInventario(this.form.value, this.inventario);
    this.inventarioService.update(this.inventarioService.buildComandoInventarioToUpdate(inventarioToUpdate)).toPromise().then(idInventario => {
      if (this.inventario.idInventario === idInventario.valor) {
        this.inventario = inventarioToUpdate;
        this.inventarioService.changeInventario(this.inventarioService.inventario, this.inventario);
        this.inventarioChange.emit(this.inventario);
        Swal.fire('Producto ha sido cambiado del inventario correctamente');
      }
    }).catch(error => {
      console.log(error);
      Swal.fire('Ha ocurrido un problema, por lo que no se pudo editar el producto del inventario');
    });
  }

  showModal(show: boolean, id: string): void {
    UtilModal.show(show, id);
  }

  changeModal(idCurrent: string, idToChange: string): void {
    UtilModal.change(idCurrent, idToChange);
  }

  setProduct(product: Producto): void {
    this.product = product;
    this.form.get('producto')?.setValue(product);
    this.changeModal('product-list', 'product-form');
  }

}
