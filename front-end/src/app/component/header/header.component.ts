import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { InventarioService } from 'src/app/service/inventario/inventario.service';
import { LoginService } from 'src/app/service/login/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  name = new FormControl('');

  constructor(private loginService: LoginService, private inventarioService: InventarioService, private router: Router) { }

  ngOnInit(): void {
  }

  search(): void {
    /* if (this.name.value !== '') {
      this.inventarioService.getInventarioBy(this.name.value).then((list)=>{
        this.inventarioService.changeProductList(list);
        this.router.navigate(['/home']);
        console.log(list);
      });
    } */
  }

  logout(): void {
    this.loginService.logout();
    Swal.fire('Has cerrado la sesión exitosamente');
    this.router.navigate(['/login']);
  }

}
