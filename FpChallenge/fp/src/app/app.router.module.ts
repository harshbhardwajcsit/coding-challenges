import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {EditorHomeComponent} from "./components/editor-home/editor-home.component";




const routes: Routes = [
  {
    path: '',
    component: EditorHomeComponent
  },
  {
    path: 'editor',
    component: EditorHomeComponent
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
