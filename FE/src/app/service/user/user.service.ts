import {Injectable} from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../../model/User";

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

  register(user?: User): Observable<any> {
    // @ts-ignore
    return this.http.post(`${API_URL}/users`, user);
  }

  getAllUsers(): Observable<any> {
    return this.http.get(`${API_URL}/users`);
  }

  findById(id: number): Observable<User> {
    return this.http.get(`${API_URL}/users/${id}`)
  }

  getUsername() {
    return this.http.get<string[]>(`${API_URL}/users/usernames`)
  }
}
