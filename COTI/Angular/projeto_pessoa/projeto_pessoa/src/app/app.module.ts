import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CadastrarPessoasComponent } from './cadastrar-pessoas/cadastrar-pessoas.component';
import { ConsultarPessoasComponent } from './consultar-pessoas/consultar-pessoas.component';

//configurar uma rota de cada componente
const routes: Routes = [
  { path: 'cadastrar-pessoas', component: CadastrarPessoasComponent }, 
  { path: 'consultar-pessoas', component: ConsultarPessoasComponent }]

@NgModule({
  declarations: [
    AppComponent,
    CadastrarPessoasComponent,
    ConsultarPessoasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule, ReactiveFormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
