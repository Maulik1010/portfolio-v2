import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiResponse, ContactRequest } from '../models/profile.model';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  private readonly baseUrl = `${environment.apiBaseUrl}/contact`;

  constructor(private http: HttpClient) {}

  sendMessage(payload: ContactRequest): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl, payload);
  }
}
