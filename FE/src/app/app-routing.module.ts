import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from "./auth/auth.component";
import {UserInfoComponent} from "./user-info/user-info.component";
import {EditUserComponent} from "./user-info/edit-user/edit-user.component";
import {ChangePasswordComponent} from "./user-info/change-password/change-password.component";
import {LibraryComponent} from "./library/library.component";

const routes: Routes = [
  {path: 'auth', component: AuthComponent},
  {path: 'user-info', component: UserInfoComponent, children: [
      {path: 'edit', component: EditUserComponent},
      {path: 'change-password', component: ChangePasswordComponent}
  ]},
  {path: 'library', component: LibraryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
