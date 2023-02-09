import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { DropdownDirective } from "./service/dropdown.directive";
import { AuthComponent } from './auth/auth.component';
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import {ReactiveFormsModule} from "@angular/forms";
import { SearchComponent } from './search/search.component';
import { SearchItemSongComponent } from './search/search-item-song/search-item-song.component';
import { SearchItemPlaylistComponent } from './search/search-item-playlist/search-item-playlist.component';
import { SearchItemUserComponent } from './search/search-item-user/search-item-user.component';
import { UserInfoComponent } from './user-info/user-info.component';
import { EditUserComponent } from './user-info/edit-user/edit-user.component';
import { ChangePasswordComponent } from './user-info/change-password/change-password.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    DropdownDirective,
    AuthComponent,
    SearchComponent,
    SearchItemSongComponent,
    SearchItemPlaylistComponent,
    SearchItemUserComponent,
    UserInfoComponent,
    EditUserComponent,
    ChangePasswordComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
