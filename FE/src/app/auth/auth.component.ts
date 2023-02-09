import {Component, OnInit} from '@angular/core';
import {
  faGooglePlusG,
  faSquareFacebook
} from "@fortawesome/free-brands-svg-icons";
import {FormControl, FormGroup, FormsModule} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit{
  faFacebook = faSquareFacebook;
  faGoogle = faGooglePlusG;
  isLogin = true;
  formLogin! : FormsModule
  constructor(private routerActive: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.formLogin = new FormGroup({
      username : new FormControl(),
      password : new FormControl()
    })
  }

  switchToLogin() {
    this.isLogin = true
  }

  switchToRegister() {
    this.isLogin = false
  }

  login() {

  }
}
