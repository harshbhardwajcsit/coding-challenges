import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {MapHomeComponent} from './components/map-home/map-home.component';
import {AppRouterModule} from './app.router.module';
import {HttpClientModule} from "@angular/common/http";
import {M2Component} from "./components/m2/m2.component";
import {Service1Service} from "./services/service1.service";

@NgModule({
  declarations: [
    AppComponent,
    MapHomeComponent,
    M2Component
  ],
  imports: [
    BrowserModule,
    AppRouterModule,
    HttpClientModule
  ],
  providers: [Service1Service],
  bootstrap: [AppComponent]
})
export class AppModule {
}
