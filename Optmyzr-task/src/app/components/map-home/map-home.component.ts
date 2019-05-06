import {Component, OnInit, ViewChild} from '@angular/core';
import {Service1Service} from "../../services/service1.service";

@Component({
  selector: 'app-map-home',
  templateUrl: './map-home.component.html',
  styleUrls: ['./map-home.component.css'],
})
export class MapHomeComponent implements OnInit {
  constructor(private service:Service1Service) {

  }

  ngOnInit() {

  }

  editData(){
    this.service.editName('abc').subscribe(response=>{

    })
  }

}





