import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Inventario } from 'src/app/model/inventario';
import { Producto } from 'src/app/model/producto';
import { InventarioService } from 'src/app/service/inventario/inventario.service';
import { ProductService } from 'src/app/service/product/product.service';
import { UtilModal } from 'src/app/util/util-modal';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {

  isNew!: boolean;
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
  productList!: Producto[];
  form!: FormGroup;

  constructor(private formBuilder: FormBuilder, private inventarioService: InventarioService, private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.getProductList().toPromise().then(list => this.productList = list).catch(error => console.log(error));
    this.buildForm();
    this.inventario ? this.form.patchValue(this.inventario) : this.inventario = this.inventarioService.getDefaultInventario();
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
    console.log('create');
    this.inventario = this.inventarioService.buildInventario(this.form.value, this.inventario);
    console.log(this.inventario);
    this.inventarioService.create(this.inventarioService.buildComandoInventarioToCreate(this.inventario)).toPromise().then(idInventario => {
      this.inventario.idInventario = idInventario
      this.inventarioService.addInventario(this.inventario);
      this.inventarioChange.emit(this.inventario);
    }).catch(error => console.log(error));
  }

  update(): void {
    console.log('update');
    console.log(this.inventario);
    this.inventario = this.inventarioService.buildInventario(this.form.value, this.inventario);
    console.log(this.inventario);
    this.inventarioService.update(this.inventarioService.buildComandoInventarioToUpdate(this.inventario)).toPromise().then(idInventario => {
      if (this.inventario.idInventario === idInventario) {
        this.inventarioService.changeInventario(this.inventarioService.inventario, this.inventario);
      }
    }).catch(error => console.log(error));
  }

  showModal(show: boolean, id: string): void {
    UtilModal.show(show, id);
  }

  changeModal(idCurrent: string, idToChange: string): void {
    UtilModal.change(idCurrent, idToChange);
  }

  setProduct(product: Producto): void {
    this.inventario.producto = product;
    this.form.get('producto')?.setValue(product);
    console.log('producto', product);
    this.changeModal('product-list', 'product-form');
  }

}
