import {Injectable} from '@angular/core';
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Injectable()
export class Service1Service {

  a: string;
  private subject = new BehaviorSubject<string>('harsh').asObservable();

  constructor() {
  }

  editName(newName) {
    this.subject.next(newName);
  }

}
