import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product.model';
import { ProductService } from 'src/app/service/product/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  productList: Product[] | undefined;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.productList = this.productService.getProducts();
    //this.productService.getProductBy().then(list => this.productList = list);
  }

  setProduct(product: Product) {
    this.productService.product = product;
  }

}
