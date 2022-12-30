import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {Order} from "../models/order";
import {MyServiceService} from "../service/my-service.service";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  orders: Order[] = [];
  customerId!: number
  constructor(private http:HttpClient, private router: Router, private route: ActivatedRoute, private service: MyServiceService) {
    this.customerId = route.snapshot.params['customerId'];
  }

  ngOnInit(): void {
    this.service.getOrdersByCustomerId(this.customerId)
      .subscribe(
        {
          next: (data) => {
            this.orders=data._embedded.orders;
          },
          error: (err)=> {}
        }
      )
  }


  getOrderDetails(o: any) {
    this.router.navigateByUrl("/order-details/"+o.id);
  }
}
