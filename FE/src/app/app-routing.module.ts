import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from "./auth/auth.component";
import {SearchComponent} from "./search/search.component";

const routes: Routes = [
  {path: 'auth', component: AuthComponent},
  {path:'search/q=:text',component:SearchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
