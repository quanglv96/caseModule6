import {Component, OnInit} from '@angular/core';
import {
  faGooglePlusG,
  faSquareFacebook
} from "@fortawesome/free-brands-svg-icons";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../service/user/user.service";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  faFacebook = faSquareFacebook;
  faGoogle = faGooglePlusG;
  isLogin = true

  loginForm: FormGroup = this.formBuilder.group({
    username: ['', {validators: Validators.required, updateOn: 'blur'}],
    password: ['', {validators: [Validators.required, Validators.minLength(6)], updateOn: 'blur'}]
  })

  registerForm: FormGroup = this.formBuilder.group({
    username: ['', {validators: Validators.required, updateOn: 'blur'}],
    password: ['', {validators: [Validators.required, Validators.minLength(6)], updateOn: 'blur'}],
    confirmPassword: ['', {validators: [Validators.required, this.confirmPassValidator.bind(this)], updateOn: 'blur'}],
    phoneNumber: ['', {validators: [Validators.required, this.phoneValidator.bind(this)], updateOn: 'blur'}]
  })

  constructor(private formBuilder: FormBuilder,
              private userService:UserService){
  }

  ngOnInit() {
    this.registerForm.controls['password'].valueChanges.subscribe(
      () => {
        this.registerForm.controls['confirmPassword'].updateValueAndValidity();
      }
    )
  }

  switchToLogin() {
    this.isLogin = true
  }

  switchToRegister() {
    this.isLogin = false
  }

  clearValid(event: Event, messDiv: HTMLDivElement) {
    let input = event.target as HTMLInputElement
    input.classList.add('clear')
    messDiv.classList.add('hide')
  }

  checkValid(event: Event, messDiv: HTMLDivElement) {
    let input = event.target as HTMLInputElement
    input.classList.remove('clear')
    messDiv.classList.remove('hide')
  }

  confirmPassValidator(control: FormControl): {[s: string]: boolean} | null {
    // @ts-ignore
    if (control.value !== '' && control.value !== control?.parent?.controls?.['password'].value) {
      return {'notMatch': true};
    }
    return null
  }

  phoneValidator(control: FormControl): {[s: string]: boolean} | null {
    let regexPattern = '^((84|0)[3|5|7|8|9])+([0-9]{8})$'
    let regex = new RegExp(regexPattern);
    if (control.value != '' && !regex.test(control.value)) {
      return {'invalidPhoneNumber': true}
    }
    return null
  }

  onRegister() {
    if (this.registerForm.invalid) {
      Object.keys(this.registerForm.controls).forEach(field => {
        const control = this.registerForm.get(field);
        control?.markAsTouched({ onlySelf: true });
      });
    } else {
      // ae code login ở đây
    }
  }

  onLogin() {
    if (!this.loginForm.valid) {
      Object.keys(this.loginForm.controls).forEach(field => {
        const control = this.loginForm.get(field);
        control?.markAsTouched({ onlySelf: true });
      });
    } else {
      this.userService.login(this.loginForm.get('username')?.value,this.loginForm.get('password')?.value).subscribe(()=>{
        alert("Login Successful")
      },(error:any)=>{
        console.log(error)
        alert(error['error']);
      })
    }
  }
}
