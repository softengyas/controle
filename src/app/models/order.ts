export interface Order {
  id: string;
  createdAt: Date;
  status: string;
  customer: Customer;
  productItems: ProductItem[];
  total: number;
}

export interface Customer {
  id: string;
  name: string;
  email: string;
}

export interface ProductItem {
  product: Product;
  quantity: number;
  price: number;
  discount: number;
}

export interface Product {
  id: string;
  name: string;
  quantity: number;
  price: number;
}


