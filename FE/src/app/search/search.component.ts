import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap} from "@angular/router";
import {SearchService} from "../service/search/search.service";
import {Songs} from "../model/Songs";
import {Playlist} from "../model/Playlist";
import {User} from "../model/User";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  search: [] = []
  resultSearch: any[] = [];
  text:any;
  resultSong:Songs[]=[];
  resultPlaylist:Playlist[]=[];
  resultUser:User[]=[];

  constructor(private activatedRoute: ActivatedRoute, private searchService:SearchService ) {

  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((param: ParamMap) => {
      const textSearch: string | null =param.get('textSearch');
      if(textSearch!=undefined){
        this.text=textSearch;
        this.text=localStorage.setItem("textSearch",this.text);
        this.result();
      }

    })
  }
  result(){
    this.searchService.resultSearch(this.text).subscribe((data:any)=>{
      this.random(data)
      this.resultSong=data[0]
      this.resultPlaylist=data[1]
      this.resultUser=data[2]
    })
  }
  random(data:any){
    let index=0;
    let list:any=[];
    let random:any=[]
    for (let i = 0; i < data.length; i++) {
      for (let j = 0; j < data[i].length; j++) {
        list.add(data[i][j]);
      }
    }
    const demoRandom:any=[];
    while (index==list.length){
      demoRandom[index]=Math.floor(Math.random()*list.length);
      random=new Set(demoRandom);
      index=random.length
    }
    for (let i = 0; i < random.length; i++) {
      this.resultSearch.push(random[i]);
    }
  }
}
