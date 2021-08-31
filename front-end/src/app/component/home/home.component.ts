import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Product } from 'src/app/model/product.model';
import { ProductService } from 'src/app/service/product/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  productList!: Product[];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.customProductList.subscribe(list => this.productList = list);
    //this.productService.getProductBy().then(list => this.productList = list);
  }

  setProduct(product: Product) {
    this.productService.product = product;
  }

}
