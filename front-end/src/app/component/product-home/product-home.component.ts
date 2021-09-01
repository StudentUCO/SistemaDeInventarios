import { Component, Input, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
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
  isDecrease = false;
  quantity = new FormControl(0);

  constructor(private productService: ProductService, private router: Router) { }

  ngOnInit(): void {
    if (this.productService.product) {
      this.product = this.productService.product;
    } else {
      this.product = {
        id: 0,
        name: 'Default',
        quantity: 0,
        price: 0,
        description: 'Default'
      };
    }
  }

  addQuantity(): void {
    this.product.quantity += this.quantity.value;
  }

  decreaseQuantity(): void {
    if (this.product.quantity >= this.quantity.value) {
      this.product.quantity -= this.quantity.value;
      this.isDecrease = false;
    } else {
      this.isDecrease = true;
    }
  }

  delete(): void {
    this.productService.removeProduct(this.product);
    this.productService.delete(this.product).then(product=>console.log(product)).catch(error=>console.log(error));
    this.router.navigate(['/home']);
  }

  showModal(show: boolean, id: string): void {
    UtilModal.show(show, id);
  }

  setIsNew(isNew: boolean): void {
    this.isNew = isNew;
  }

}
