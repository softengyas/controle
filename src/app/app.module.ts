import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { ProductsComponent } from './products/products.component';
import { AppRoutingModule } from './app-routing.module';
import { CustomersComponent } from './customers/customers.component';
import { OrdersComponent } from './orders/orders.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";

export function kcFactory(kcService: KeycloakService) {
  return () => {
    kcService.init({
      config: {
        realm: "invoice-realm",
        clientId: "invoice-client",
        url: "http://localhost:8080"
      },
      initOptions: {
        onLoad: "check-sso",
        checkLoginIframe: true
      }
    });
  }
}


@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    CustomersComponent,
    OrdersComponent,
    OrderDetailsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    KeycloakAngularModule
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      deps: [KeycloakService],
      useFactory: kcFactory,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
