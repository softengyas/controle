import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {Order} from "../models/order";
import {MyServiceService} from "../service/my-service.service";

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {
  orderDetails!: Order
  orderId!: number
  constructor(private http:HttpClient, private router: Router, private route: ActivatedRoute, private service: MyServiceService) {
    this.orderId = route.snapshot.params['orderId'];
  }

  ngOnInit(): void {
    this.service.getOrderDetails(this.orderId)
      .subscribe(
        {
          next: (data) => {
            this.orderDetails=data;
          },
          error: (err)=> {}
        }
      )
  }
}
