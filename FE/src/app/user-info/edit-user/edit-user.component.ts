import { Component } from '@angular/core';
import * as $ from 'jquery'
import {FormBuilder, FormControl, Validators} from "@angular/forms";

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent {
  editImage: string | ArrayBuffer | null = ''

  userForm = this.formBuilder.group({
    name: ['', {validators: Validators.required, updateOn: 'blur'}],
    email: ['', {validators: [Validators.required, Validators.email], updateOn: 'blur'}],
    address: [''],
    phoneNumber: ['', {validators: [Validators.required, this.phoneValidator.bind(this)], updateOn: 'blur'}],
    avatar: ['']
  });

  constructor(private formBuilder: FormBuilder) {
  }

  openUpload(s: string) {
    $(s).trigger('click')
  }

  renderImagePath(event: any) {
    const files = event.target.files;
    const reader = new FileReader()
    if (files && files[0]) {
      reader.onload = () => {
        this.editImage = reader.result
      }
      reader.readAsDataURL(files[0])
    }
  }

  saveChange() {
    if (!this.userForm.valid) {
      Object.keys(this.userForm.controls).forEach(field => {
        const control = this.userForm.get(field);
        control?.markAsTouched({ onlySelf: true });
      });
    } else {

      // code phan update user o day

    }
  }

  clearValid(event: Event, messDiv: HTMLDivElement) {
    let input = event.target as HTMLInputElement
    input.classList.add('clear')
    messDiv.classList.add('hide')
  }

  checkValid(event: FocusEvent, messDiv: HTMLDivElement) {
    let input = event.target as HTMLInputElement
    input.classList.remove('clear')
    messDiv.classList.remove('hide')
  }

  phoneValidator(control: FormControl): {[s: string]: boolean} | null {
    let regexPattern = '^((84|0)[3|5|7|8|9])+([0-9]{8})$'
    let regex = new RegExp(regexPattern);
    if (control.value != '' && !regex.test(control.value)) {
      return {'invalidPhoneNumber': true}
    }
    return null
  }
}
