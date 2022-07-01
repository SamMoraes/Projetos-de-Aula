import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment'

@Component({
  selector: 'app-editar-pessoas',
  templateUrl: './editar-pessoas.component.html',
  styleUrls: ['./editar-pessoas.component.css']
})
export class EditarPessoasComponent implements OnInit {

  //atributo msg
  mensagem: String = ''

  constructor(
    private httpClient: HttpClient,
    private activatedRoute: ActivatedRoute,
    public datepipe: DatePipe
  ) { 

  }
  

  ngOnInit(): void {
    const idPessoa = this.activatedRoute.snapshot.paramMap.get('id') as string;

    this.httpClient.get(environment.apiUrl + '/pessoa/' + idPessoa).subscribe(
      (data: any) => {
        this.formEdicao.patchValue(data)
      },
      (e) => {
        console.log(e)
      }
    )
  }

  

  //estrutura do form
  formEdicao = new FormGroup({
    idPessoa: new FormControl(''),
    nome: new FormControl('', [Validators.required]),
    dataNasc: new FormControl('', [Validators.required]),
    cpf: new FormControl('', [Validators.required]),
    sexo: new FormControl('', [Validators.required]),
    altura: new FormControl('', [Validators.required]),
    peso: new FormControl('', [Validators.required])
    

  })


    get form(): any{
      return this.formEdicao.controls 
    }

    onSubmit(): void {
      this.httpClient.put(
        environment.apiUrl + '/pessoa', this.formEdicao.value,{
          responseType: 'text'
        }).subscribe(
          data => {
            this.mensagem = data
          },
          e => {
            this.mensagem = "Ocorreu um erro, a edição não foi realizada.",
            console.log(e)
          }
          
        )
    }
}
