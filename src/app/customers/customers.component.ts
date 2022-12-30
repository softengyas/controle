import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {MyServiceService} from "../service/my-service.service";
import {Customer} from "../models/order";
import {ApiResponse} from "../models/apiResponse";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {
customers: Customer[] = [];
  constructor(private http:HttpClient, private router: Router, private service:MyServiceService) { }

  ngOnInit(): void {
    this.service.getCustomers()
      .subscribe(
        {
          next: (data:ApiResponse) => {
            this.customers=data._embedded.customers;
          },
          error: (err)=> {}
        }
      )
  }

  getOrders(c: any) {
    this.router.navigateByUrl("/orders/" + c.id);
  }
}
