import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { MapHomeComponent } from './components/map-home/map-home.component';
import { InfoWindowComponent } from './components/info-window/info-window.component';
import {AppRouterModule} from './app.router.module';
import {AgmCoreModule} from '@agm/core';
import {HttpClientModule} from "@angular/common/http";
import {GetWeatherInfoService} from "./services/getWeatherInfo/get-weather-info.service";
import {ApplicationUrlService} from "./services/applicationUrlService/application-url.service";
import {GetTimeStampService} from "./services/getTimeStamp/get-time-stamp.service";



@NgModule({
  declarations: [
    AppComponent,
    MapHomeComponent,
    InfoWindowComponent
  ],
  imports: [
    BrowserModule,
    AppRouterModule,
    HttpClientModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAIa3yZTOXXlknH_2VGoPKLe_cE3GVMjoU'
    })
  ],
  providers: [ApplicationUrlService,GetTimeStampService],
  bootstrap: [AppComponent]
})
export class AppModule { }
