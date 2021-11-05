import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Producto } from 'src/app/model/producto';
import { ServiceUtil } from 'src/app/util/service-util';
import { environment } from 'src/environments/environment';

const URL = environment.url + 'producto';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  product!: Producto;

  private productList = new BehaviorSubject<Producto[]>([]);
  customProductList = this.productList.asObservable();

  constructor(private http: HttpClient, private serviceUtil: ServiceUtil) { }

  changeProductList(productList: Producto[]): void {
    this.productList.next(productList);
  }

  getProductList(): Observable<Producto[]> {
    if (!this.productList || this.productList.value.length === 0) {
      return this.http.get<Producto[]>(URL, {headers: this.serviceUtil.getSimpleHeader()});
    }
    return this.productList;
  }

  create(product: Producto): Observable<{valor: number}> {
    console.log('create', this.serviceUtil.getJsonHeader());
    return this.http.post<{valor: number}>(URL, product, {headers: this.serviceUtil.getJsonHeader()});
  }

  update(product: Producto): Observable<{valor: number}> {
    console.log('update',this.serviceUtil.getJsonHeader());
    return this.http.put<{valor: number}>(URL + `/${product.idProducto}`, product, {headers: this.serviceUtil.getJsonHeader()});
  }

  delete(idProducto: number): Observable<{valor: number}> {
    console.log('delete', this.serviceUtil.getSimpleHeader());
    return this.http.delete<{valor: number}>(URL + `/${idProducto}`, { headers: this.serviceUtil.getSimpleHeader() });
  }

  addProduct(product: Producto): void {
    this.productList.value.push(product);
    console.log(this.productList.value);
  }

  changeProduct(oldProduct: Producto, newProduct: Producto): void {
    this.productList.value[this.productList.value.indexOf(oldProduct)] = newProduct;
  }

  removeProduct(product: Producto): void {
    this.productList.value.splice(this.productList.value.indexOf(product));
  }

  buildProduct(form: any, productToUpdate?: Producto): Producto {
    console.log(form);
    console.log(this.productList.value.length);
    let product: Producto = {
      ...productToUpdate,
      ...form,
      idProducto: productToUpdate?.idProducto? productToUpdate.idProducto : ''
    };
    return product;
  }

  getDefaultProduct(): Producto {
    return {
      idProducto: 0,
      nombre: 'Default',
      codigo: '#####',
      activo: false,
    }
  }
}
