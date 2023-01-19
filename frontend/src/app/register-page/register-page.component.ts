import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../_auth/authentication.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {passwordMatchingValidator} from "./password.matching.validator";

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {
  public registerForm!: FormGroup;

  constructor(private authService: AuthenticationService) {
  }

  ngOnInit(): void {
    this.registerForm = new FormGroup({
      nickName: new FormControl('', [Validators.required, Validators.pattern(/\S/)]),
      password: new FormControl('', [Validators.required, Validators.minLength(5)]),
      confirmPassword: new FormControl('', Validators.required)
    }, {validators: passwordMatchingValidator})
  }

  public registerFormControl() {
    return this.registerForm.controls;
  }

  public onSubmit() {
    this.authService.register({nickName: this.registerForm.get('nickName')!.value,
        password: this.registerForm!.get('password')!.value});
  }
}
