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
    this.productService.getProductList().then(list => {
      this.productList = list;
      this.productService.changeProductList(list);
      console.log(list);
      console.log(list.length);
    }).catch(error=>console.log(error));
    this.productService.customProductList.subscribe(list => this.productList = list);
  }

  setProduct(product: Product) {
    this.productService.product = product;
  }

}
