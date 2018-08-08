import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-info-window',
  templateUrl: './info-window.component.html',
  styleUrls: ['./info-window.component.css']
})
export class InfoWindowComponent implements OnInit {

  constructor() { }
  list=["Item1","Item2","Item3"];

  ngOnInit() {

  }

}
