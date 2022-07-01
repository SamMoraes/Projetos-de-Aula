import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CadastrarPessoasComponent } from './cadastrar-pessoas/cadastrar-pessoas.component';
import { ConsultarPessoasComponent } from './consultar-pessoas/consultar-pessoas.component';
import { EditarPessoasComponent } from './editar-pessoas/editar-pessoas.component';
import { DatePipe } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

//configurar uma rota de cada componente
const routes: Routes = [
  { path: '', component: CadastrarPessoasComponent },
  { path: 'cadastrar-pessoas', component: CadastrarPessoasComponent }, 
  { path: 'consultar-pessoas', component: ConsultarPessoasComponent },
  { path: 'editar-pessoas/:id', component: EditarPessoasComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    CadastrarPessoasComponent,
    ConsultarPessoasComponent,
    EditarPessoasComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule, ReactiveFormsModule,
    RouterModule.forRoot(routes),
    BrowserAnimationsModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
