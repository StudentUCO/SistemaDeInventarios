import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from 'src/app/model/product.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  product?: Product;

  constructor(private http: HttpClient) { }

  getProducts(): Product[] {
    const list = [];
    for(let i=1; i<=10; i++) {
      list.push({
        id: i,
        name: 'Arduino Uno ' + i,
        quantity: i*123,
        price: i*9876,
        description: 'Default ' + i
      });
    }
    return list;
  }

  getProductBy(): Promise<Product[]> {
    return this.http.get<Product[]>(environment.url).toPromise();
  }

  create(product: Product): Promise<Product> {
    return this.http.post<Product>(environment.url, product).toPromise();;
  }

  update(product: Product): Promise<Product> {
    return this.http.put<Product>(environment.url, product).toPromise();
  }

  delete(product: Product): Promise<Product> {
    return this.http.delete<Product>(environment.url).toPromise();
  }
}
