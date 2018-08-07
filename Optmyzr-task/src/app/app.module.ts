import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { MapHomeComponent } from './components/map-home/map-home.component';
import { InfoWindowComponent } from './components/info-window/info-window.component';
import {AppRouterModule} from './app.router.module';
import {AgmCoreModule} from '@agm/core';



@NgModule({
  declarations: [
    AppComponent,
    MapHomeComponent,
    InfoWindowComponent
  ],
  imports: [
    BrowserModule,
    AppRouterModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyA_YsNXKIQ9qgFlkNVK0SA8A1WP3Cq6jew'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
