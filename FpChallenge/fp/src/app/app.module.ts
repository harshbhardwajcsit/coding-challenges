import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ColorPickerModule } from 'ngx-color-picker';

import { AppComponent } from './app.component';

import {AppRouterModule} from "./app.router.module";
import {EditorHomeComponent} from "./components/editor-home/editor-home.component";

@NgModule({
  declarations: [
    AppComponent,
    EditorHomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ColorPickerModule,
    AppRouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
