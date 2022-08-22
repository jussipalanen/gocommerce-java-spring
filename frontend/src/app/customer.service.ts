import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from './customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customerUrl: string;

  constructor(private http: HttpClient) {
    this.customerUrl = 'http://localhost:9000/api/v1/customers';
  }

  public findAll(): Observable<Customer[]>{
    return this.http.get<Customer[]>(this.customerUrl);
  }

  public save(customer: Customer)
  {
    return this.http.post<Customer>(this.customerUrl, customer);
  }
}
