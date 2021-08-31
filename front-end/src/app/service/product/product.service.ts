import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Product } from 'src/app/model/product.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  product!: Product;
  
  private productList = new BehaviorSubject<Product[]>([]);
  customProductList = this.productList.asObservable();

  constructor(private http: HttpClient) { }

  changeProductList(productList: Product[]): void {
    this.productList.next(productList);
  }

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

  getProductList(): Promise<Product[]> {
    return this.http.get<Product[]>(environment.url).toPromise();
  }

  getProductBy(name: string): Promise<Product[]> {
    console.log(name);
    return this.http.get<Product[]>(environment.urlProducts).toPromise();
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
