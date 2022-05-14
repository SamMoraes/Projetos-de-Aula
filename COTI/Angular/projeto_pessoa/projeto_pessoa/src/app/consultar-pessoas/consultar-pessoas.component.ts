import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

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
    this.httpClient.get('http://localhost:8080/api/pessoa').subscribe(
      (data) => {
        this.pessoas = data as any[]
      },
      (e) => {
        console.log(e)
      }
    )
  }

}
