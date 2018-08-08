import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {MapHomeComponent} from './components/map-home/map-home.component';
import {InfoWindowComponent} from "./components/info-window/info-window.component";



const routes: Routes = [
  {
    path: '',
    component: MapHomeComponent
  },
  {
    path: 'world-map',
    component: MapHomeComponent
  },
  {
    path: 'info-window',
    component: InfoWindowComponent
  }


];


@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRouterModule { }
