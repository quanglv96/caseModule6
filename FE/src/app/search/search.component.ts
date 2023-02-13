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
  search: [] = [];
  text:any;
  resultSearch: any[] = [];
  resultSong:Songs[]=[];
  resultPlaylist:Playlist[]=[];
  resultUser:User[]=[];
  category:string ='';
  resultContent: string='';
  statisticalContent: string='Search for tracks, artists, podcasts, and playlists.';

  constructor(private activatedRoute: ActivatedRoute, private searchService:SearchService ) {

  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((param: ParamMap) => {
      this.resultSearch=[];
      const textSearch: string | null =param.get('textSearch');
      if(textSearch!=''){
        this.text=textSearch;
        this.result();
        this.resultContent='result for "'+this.text+'"'
        this.category='';
      }else {
        this.resultContent='';
        this.statisticalContent='Search for tracks, artists, podcasts, and playlists.';
      }

    })
  }
  result(){
    this.searchService.resultSearch(this.text).subscribe((data:any)=>{
      this.random(data)
      this.resultSong=data[0]
      this.resultPlaylist=data[1]
      this.resultUser=data[2]
      this.statisticalContent=`Found ${this.resultSong.length} Songs, ${this.resultUser.length} people, ${this.resultPlaylist.length} playlists`
      localStorage.setItem('resultSearch',JSON.stringify(this.resultSearch));
    })
  }
  random(data:any){

    let index:number=0;
    let list:any=[];
    let random:any=[]
    for (let i = 0; i < data.length; i++) {
      const demo=data[i]
      for (let j = 0; j < demo.length; j++) {
        list.push(demo[j]);
      }
    }
    const demoRandom:any=[];
    while (index!=list.length){
      demoRandom[index]=Math.floor(Math.random()*list.length);
      random=Array.from(new Set(demoRandom));
      index=random.length;
    }
    for (let i = 0; i < random.length; i++) {
      this.resultSearch.push(list[random[i]]);
    }

  }

  fillCategory(text: string) {
    this.category=text;
  }
}
