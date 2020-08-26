import { Component, OnInit } from '@angular/core';
import { HttpClient  } from '@angular/common/http';

@Component({
  selector: 'app-about-us',
  templateUrl: './about-us.component.html',
  styleUrls: ['./about-us.component.css']
})
export class AboutUsComponent implements OnInit {
contributors:string[] = [ 'Barbara', 'Christopher', 'Navjot', 'Mihail' ];
is_amazing:string[] = [ ' is a glorious programmer',' is an astonishg software engineer',' is an incredible programming engineer', 'is ok']
img:string[] = [
  'https://www.pexels.com/photo/waterfall-nature-6832/',
'https://newwallpapershd.com/wp-content/uploads/2014/09/beautiful-moonlight-green-full-HD-nature-background-wallpaper-for-laptop-widescreen-150x150.jpg',
'https://cdn.slidesharecdn.com/ss_thumbnails/wonderful-nature-1197818424715202-4-thumbnail.jpg?cb=1223686461',
'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fgrendz.com%2Fwp-content%2Fuploads%2F2015%2F08%2Fhd-nature-free-wallpaper-images-picture-hd-wallpapers-hd-1440761414gk48n-150x150.jpg&f=1&nofb=1'
]
  title = 'image-gallery';
  public data: any = [];

  constructor(private http: HttpClient) {
  }

  getData(): void{
    const url = 'https://jsonplaceholder.typicode.com/photos?albumId=1';
    this.http.get(url).subscribe((res) => {
      this.data = res;
      console.log(this.data);
    });
}

ngOnInit(): void {
  this.getData();
}

}
