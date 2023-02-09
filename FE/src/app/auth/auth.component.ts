import { Component } from '@angular/core';
import {
  faGooglePlusG,
  faSquareFacebook
} from "@fortawesome/free-brands-svg-icons";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent {
  faFacebook = faSquareFacebook;
  faGoogle = faGooglePlusG;
  isLogin = true

  switchToLogin() {
    this.isLogin = true
  }

  switchToRegister() {
    this.isLogin = false
  }
}
