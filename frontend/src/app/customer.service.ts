import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from './customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private baseUrl = 'http://localhost:9000/api/v1/customers/';

  constructor(private http: HttpClient) {
  }

  public findById(id: number):Observable<any> 
  {
    return this.http.get(this.baseUrl + id);
  }

  public findAll(): Observable<Customer[]>{
    return this.http.get<Customer[]>(this.baseUrl);
  }

  public update(customer: Customer)
  {
    return this.http.put<Customer>(this.baseUrl + customer.id, customer);
  }

  public save(customer: Customer)
  {
    return this.http.post<Customer>(this.baseUrl, customer);
  }
}
