import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-cadastrar-pessoas',
  templateUrl: './cadastrar-pessoas.component.html',
  styleUrls: ['./cadastrar-pessoas.component.css']
})
export class CadastrarPessoasComponent implements OnInit {

//atributo de msg
mensagem: string = '';

  constructor(
    private httpClient: HttpClient
  ) { }

  //estrutura do formulário
  formCadastro = new FormGroup({
    //campos do formulário
    nome: new FormControl('', [Validators.required]),
    dataNasc: new FormControl('', [Validators.required]),
    cpf: new FormControl('', [Validators.required]),
    sexo: new FormControl('', [Validators.required]),
    altura: new FormControl('', [Validators.required]),
    peso: new FormControl('', [Validators.required])

  })
  
  //acesso do form
  get form(): any {
    return this.formCadastro.controls
  }
  ngOnInit(): void {
  }

  //cadastrar na API
  onSubmit(): void{

    this.httpClient.post(
      environment.apiUrl + '/pessoa',
      this.formCadastro.value,{
        responseType: 'text' }).subscribe(
          data => {
            this.mensagem = data,
            this.formCadastro.reset()
          },
          e => {
            this.mensagem = "Ocorreu um erro, o cadastro não foi realizado",
            console.log(e)
          }
        )
  }






}
