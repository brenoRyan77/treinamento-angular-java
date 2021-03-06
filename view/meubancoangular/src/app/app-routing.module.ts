import { ContasComponent } from './pages/contas/contas.component';
import { CadastrarClientesComponent } from './pages/clientes/cadastrar-clientes/cadastrar-clientes.component';

import { ClientesComponent } from './pages/clientes/clientes.component';
import { DepositoComponent } from './pages/deposito/deposito.component';
import { SaqueComponent } from './pages/saque/saque.component';
import { ExtratoComponent } from './pages/extrato/extrato.component';
import { HomeComponent } from './pages/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component:HomeComponent, pathMatch: 'full'},
  { path: 'extrato', component:ExtratoComponent},
  { path: 'saque', component:SaqueComponent},
  { path: 'deposito', component:DepositoComponent},
  { path: 'clientes', component:ClientesComponent},
  { path: 'cadastrar-clientes', component:CadastrarClientesComponent},
  { path: 'contas', component:ContasComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
