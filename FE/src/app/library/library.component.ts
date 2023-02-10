import {Component, OnInit} from '@angular/core';
import {UserService} from "../service/user/user.service";
import {User} from "../model/User";

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {
  constructor(private userService: UserService) {
  }

  idUser: any;
  user: User | any;
  avatar:any;
  username:any
  ngOnInit(): void {
    localStorage.setItem('idUser', '1')
    this.idUser = localStorage.getItem('idUser')
    this.userService.findById(this.idUser).subscribe((data:User)=>{
      this.user=data;
      this.avatar=this.user.avatar
      this.username=this.user.username
    });
  }

}
