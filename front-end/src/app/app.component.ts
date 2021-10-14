import { Component } from '@angular/core';
import { LoginService } from './service/login/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'front-end';

  constructor(private loginService: LoginService){}

  isAuthenticated(): boolean{
     return this.loginService.isAuthenticated();
  }
}


