import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { ProductHomeComponent } from './component/product-home/product-home.component';
import { LoginComponent } from './component/login/login.component';
import { ProductoComponent } from './component/producto/producto.component';

const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'product-home',
    component: ProductHomeComponent
  },
  {
    path: 'producto',
    component: ProductoComponent
  },
  { path: 'login', component: LoginComponent},
  { path: '**' , pathMatch: 'full' , redirectTo: 'login'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
