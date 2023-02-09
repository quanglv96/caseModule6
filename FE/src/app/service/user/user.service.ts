import {Injectable} from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  login(username: string, password: string): Observable<any> {

    // @ts-ignore
    return this.http.post(`${API_URL}/users/login?username=${username}&pass=${password}`)
  }
}
