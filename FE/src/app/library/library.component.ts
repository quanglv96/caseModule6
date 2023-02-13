import {Component} from '@angular/core';
import {NavigationEnd, Router} from "@angular/router";

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent {
  childPath: string = ''

  constructor(private router: Router) {
    router.events.subscribe(
      event => {
        if (event instanceof NavigationEnd) {
          let fullPath = event.url.split('/')
          this.childPath = fullPath[fullPath.length - 1];
        }
      }
    )
  }

  toAddForm() {
    console.log(this.childPath)
    if (this.childPath === 'song') {
      this.router.navigate(['/library/song/new']).finally()
    } else if (this.childPath === 'playlist') {
      this.router.navigate(['/library/playlist/new']).finally()
    }
  }
}
