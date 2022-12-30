import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Order} from "../models/order";
import {ApiResponse} from "../models/apiResponse";

@Injectable({
  providedIn: 'root'
})
export class MyServiceService {
   url = "http://localhost:8888";

  constructor(private http: HttpClient) { }

  getOrderDetails(orderId: number) {
    return this.http.get<Order>(`${this.url}/ORDER-SERVICE/fullOrder/${orderId}`);
  }

  getCustomers() {
    return this.http.get<ApiResponse>(this.url+"/CUSTOMER-SERVICE/customers?projection=fullCustomer");
  }

  getOrdersByCustomerId(customerId: number) {
    return this.http.get<ApiResponse>(`${this.url}/ORDER-SERVICE/orders/search/byCustomerId?customerId=${customerId}&projection=fullOrder`);
  }

  getProducts() {
    return this.http.get<ApiResponse>(this.url+"/PRODUCT-SERVICE/products?projection=fullProduct");
  }
}
