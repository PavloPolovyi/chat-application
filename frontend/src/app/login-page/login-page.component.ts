import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthenticationService} from "../_auth/authentication.service";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  loginForm!: FormGroup;

  constructor(private authService: AuthenticationService) {
  }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      nickName: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });
  }

  public onSubmit() {
    this.authService.login({nickName:this.loginForm.get('nickName')!.value,
      password: this.loginForm!.get('password')!.value});
  }
}
