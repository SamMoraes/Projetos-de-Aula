import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
 
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 
  mensagem_sucesso: string = '';
  mensagem_erro: string = '';
 
  constructor(
    private httpClient: HttpClient
  ) { }
 
  //montando a estrutura do formulário
  formLogin = new FormGroup({
    login: new FormControl('', [Validators.required]),
    senha: new FormControl('', [Validators.required])
  });
 
  //acessando o formulário/campos na página HTML
  get form(): any {
    return this.formLogin.controls;
  }
 
  ngOnInit(): void {
  }
 
  onSubmit(): void {
 
    this.mensagem_sucesso = '';
    this.mensagem_erro = '';
 
    this.httpClient.post(environment.apiUrl + "/login", this.formLogin.value,
      { responseType: 'text' })
      .subscribe(
        data => {
          this.mensagem_sucesso = 'Autenticação realizada com sucesso!';
          this.formLogin.reset();
 
          //salvar o TOKEN na LOCAL STORAGE
          localStorage.setItem('access_token', data);
 
        },
        e => {
          this.mensagem_erro = e.error;
          console.log(e.error);
        }
      );
 
  }
 
}
 


