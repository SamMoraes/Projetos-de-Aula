import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-consultar-pessoas',
  templateUrl: './consultar-pessoas.component.html',
  styleUrls: ['./consultar-pessoas.component.css']
})
export class ConsultarPessoasComponent implements OnInit {

//atributo para armazenar os dados das pessoas
pessoas: any[] = [];

//injeção de dependencia 
constructor(
  private httpClient: HttpClient
  ) { }
    
  ngOnInit(): void {
    this.httpClient.get(environment.apiUrl + '/pessoa').subscribe(
      (data) => {
        this.pessoas = data as any[]
      },
      (e) => {
        console.log(e)
      }
    )
  }

  //exclusao
  excluir(idPessoa: number): void{
    if (window.confirm ('Deseja realmente excluir a pessoa selecionada?')){
      this.httpClient.delete(environment.apiUrl + '/pessoa/' + idPessoa,
      {responseType : 'text'}).subscribe( 
          (data) => {
            alert(data), // exibir popup
            this.ngOnInit() //recarregar form de consulta
          },
          (e) => {
            console.log(e)
          }
        )
    }
  }

  //pesoIdeal
  pesoIdeal(idPessoa: number): void{
    if (window.confirm ('Deseja ver o peso ideal da pessoa selecionada?')){
      this.httpClient.get(environment.apiUrl + '/pessoa/' + idPessoa + '/pesoIdeal',
      {responseType : 'text'}).subscribe( 
          (data : any) => {
            alert(data), // exibir popup
            this.ngOnInit() //recarregar form de consulta
          },
          (e) => {
            console.log(e)
          }
        )
    }
  }

}
