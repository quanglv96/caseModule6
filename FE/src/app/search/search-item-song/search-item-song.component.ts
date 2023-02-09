import { Component } from '@angular/core';
import {faPlayCircle} from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'app-search-item-song',
  templateUrl: './search-item-song.component.html',
  styleUrls: ['./search-item-song.component.css']
})
export class SearchItemSongComponent {
  faPlay = faPlayCircle
}
