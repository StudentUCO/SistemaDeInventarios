import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Product } from 'src/app/model/product.model';
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
    this.isNew=isNew;
  }
  @Input() product!: Product;
  @Output() productChange = new EventEmitter<Product>();
  /* @Input() set setProduct(product: Product) {
    this.product = product;
    this.buildForm();
    this.form?.patchValue(product);
  };
  product?: Product; */
  form!: FormGroup;

  constructor(private formBuilder: FormBuilder, private productService: ProductService) { }

  ngOnInit(): void {
    this.buildForm();
    this.product? this.form?.patchValue(this.product) : undefined;
  }

  buildForm(): void {
    this.form = this.formBuilder.group({
      name: ['', ],
      quantity: [0, ],
      price: [0, ],
      description: ['', ]
    });
  }

  save(): void {
    if (this.isNew) {
      this.create();
    } else {
      this.update();
    }
    this.productChange.emit(this.product);
    this.showModal(false, 'product-form');
  }

  create(): void {
    console.log('create');
    this.product = this.productService.buildProduct(this.form);
    this.productService.addProduct(this.product);
    this.productService.create(this.product).then(product=>{
      this.product=product;
      console.log(product);
    }).catch(error=>console.log(error));
  }

  update(): void {
    console.log('update');
    console.log(this.product);
    this.product = this.productService.buildProduct(this.form);
    console.log(this.product);
    this.productService.changeProduct(this.productService.product, this.product);
    this.productService.update(this.product).then(product=>this.product=product).catch(error=>console.log(error));
  }

  showModal(show: boolean, id: string): void {
    UtilModal.show(show, id);
  }

}
