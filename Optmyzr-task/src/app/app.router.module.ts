import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {MapHomeComponent} from './components/map-home/map-home.component';



const routes: Routes = [
  {
    path: '',
    component: MapHomeComponent
  },
  {
    path: 'world-map',
    component: MapHomeComponent
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
