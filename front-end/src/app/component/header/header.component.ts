import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/service/product/product.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  name = new FormControl('');

  constructor(private productService: ProductService, private router: Router) { }

  ngOnInit(): void {
  }

  search(): void {
    if (this.name.value !== '') {
      this.productService.getProductBy(this.name.value).then((list)=>{
        this.productService.changeProductList(list);
        this.router.navigate(['/home']);
        console.log(list);
      });
    }
  }

}
