import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';

const routes: Routes = [
  { path: 'dev', component: EmployeeComponent },
  { path: 'test', component: EmployeeComponent },
  { path: 'devops', component: EmployeeComponent },
  { path: '', redirectTo: '/dev', pathMatch: 'full' }, // redirige vers '/dev' par défaut
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
