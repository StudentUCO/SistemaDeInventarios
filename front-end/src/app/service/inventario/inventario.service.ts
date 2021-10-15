import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { ComandoInventario } from 'src/app/comando/comando-inventario';
import { Inventario } from 'src/app/model/inventario';
import { ServiceUtil } from 'src/app/util/service-util';
import { environment } from 'src/environments/environment';

const URL = environment.url + 'inventario';

@Injectable({
  providedIn: 'root'
})
export class InventarioService {

  inventario!: Inventario;

  private inventarioList = new BehaviorSubject<Inventario[]>([]);
  customInventarioList = this.inventarioList.asObservable();

  constructor(private http: HttpClient, private serviceUtil: ServiceUtil) { }

  changeInventario(oldInventario: Inventario, newInventario: Inventario): void {
    this.inventarioList.value[this.inventarioList.value.indexOf(oldInventario)] = newInventario;
  }

  changeInventarioList(inventarioList: Inventario[]): void {
    this.inventarioList.next(inventarioList);
  }

  getAll(): Observable<Inventario[]> {
    if (!this.inventarioList || this.inventarioList.value.length === 0) {
      return this.http.get<Inventario[]>(URL, {headers: this.serviceUtil.getSimpleHeader()});
    }
    return this.inventarioList;
  }

  create(comandoInventario: Partial<ComandoInventario>): Observable<number> {
    console.log(comandoInventario);
    return this.http.post<number>(URL, comandoInventario, {headers: this.serviceUtil.getJsonHeader()});
  }

  update(comandoInventario: ComandoInventario): Observable<number> {
    return this.http.put<number>(URL, comandoInventario, {headers: this.serviceUtil.getJsonHeader()});
  }

  delete(idInventario: number): Observable<number> {
    return this.http.delete<number>(URL + `/${idInventario}`, {headers: this.serviceUtil.getSimpleHeader()});
  }

  addInventario(inventario: Inventario): void {
    this.inventarioList.value.push(inventario);
  }

  removeInventario(inventario: Inventario): void {
    this.inventarioList.value.splice(this.inventarioList.value.indexOf(inventario));
  }

  buildInventario(form: any, inventarioToUpdate: Inventario): Inventario {
    console.log('form', form);
    const inventario: Inventario = {
      ...inventarioToUpdate,
      ...form
    }
    return inventario;
  }

  buildComandoInventarioToCreate(inventario: Inventario): Partial<ComandoInventario> {
    const comandoInventario: Partial<ComandoInventario> = {
      idProducto: inventario.producto.idProducto,
      cantidad: inventario.cantidad
    }
    return comandoInventario;
  }

  buildComandoInventarioToUpdate(inventario: Inventario): ComandoInventario {
    const comandoInventario: ComandoInventario = {
      idInventario: inventario.idInventario,
      idProducto: inventario.producto.idProducto,
      cantidad: inventario.cantidad
    }
    return comandoInventario;
  }

  getDefaultInventario(): Inventario {
    return {
      idInventario: 0,
      producto: {
        idProducto: 0,
        nombre: 'Default',
        codigo: '#####',
        activo: false,
      },
      cantidad: 0
    };
  }

}
