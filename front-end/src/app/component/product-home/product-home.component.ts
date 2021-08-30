import { Component, Input, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Product } from 'src/app/model/product.model';
import { ProductService } from 'src/app/service/product/product.service';
import { UtilModal } from 'src/app/util/util-modal';

@Component({
  selector: 'app-product-home',
  templateUrl: './product-home.component.html',
  styleUrls: ['./product-home.component.css']
})
export class ProductHomeComponent implements OnInit {

  @Input() product!: Product;
  isNew!: boolean;
  quantity = new FormControl(0);

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    if (this.productService.product) {
      this.product = this.productService.product;
    }
  }

  create() {
    this.product = {
      id: 0,
      name: 'Default',
      quantity: 0,
      price: 0,
      description: 'Default'
    }
    console.log('create');
    this.productService.create(this.product).then(pto => console.log(pto));
  }

  addQuantity(): void {
    this.product.quantity += this.quantity.value;
  }

  decreaseQuantity(): void {
    if ((this.product.quantity-this.quantity.value) >= 0) {
      this.product.quantity -= this.quantity.value;
    }
  }

  showModal(show: boolean, id: string): void {
    UtilModal.show(show, id);
  }

  setIsNew(isNew: boolean): void {
    this.isNew = isNew;
  }

}
