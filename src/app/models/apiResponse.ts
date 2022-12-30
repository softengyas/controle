import {Customer, Order, Product} from "./order";

export interface ApiResponse {
  _embedded: {
    orders: Order[];
    customers: Customer[];
    products: Product[];
  };
}
