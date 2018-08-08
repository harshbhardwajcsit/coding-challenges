import { Injectable } from '@angular/core';

@Injectable()
export class GetTimeStampService {

  constructor() { }

  getTimeStamp():any {
    let now = new Date();
    return Date.UTC(now.getFullYear(), now.getMonth(), now.getDate(), now.getHours(), now.getMinutes(), now.getSeconds())/1000;
  }

}
