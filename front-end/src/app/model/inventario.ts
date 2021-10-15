import { Producto } from "./producto";

export interface Inventario {
    idInventario: number;
    producto: Producto;
    cantidad: number;
}