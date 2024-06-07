import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private apiUrl = 'http://localhost:8080/api/roles';

  constructor(private http: HttpClient) { }

  findAllByRole(role: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/${role}`);
  }
}