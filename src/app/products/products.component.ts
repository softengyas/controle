import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Product} from "../models/order";
import {MyServiceService} from "../service/my-service.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products: Product[] = [];

  constructor(private http: HttpClient, private service:MyServiceService) { }

  ngOnInit(): void {
    this.service.getProducts()
      .subscribe(
        {
          next: (data) => {
            console.log(data)
            this.products = data._embedded.products;
          },
          error: (err)=> {}
        }
      )
  }

}
