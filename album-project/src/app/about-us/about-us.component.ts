import { Component, OnInit } from '@angular/core';
import { HttpClient  } from '@angular/common/http';

@Component({
  selector: 'app-about-us',
  templateUrl: './about-us.component.html',
  styleUrls: ['./about-us.component.css']
})
export class AboutUsComponent implements OnInit {
contributors: Array<string> = [ 'Barbara', 'Christopher', 'Navjot', 'Mihail' ];

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
