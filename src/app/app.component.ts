import { Component } from '@angular/core';
import {SecurityService} from "./service/security.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'invoice-yassine-lambarki';



  constructor(public securityService : SecurityService) {}

  ngOnInit() {
  }

  async login() {
    await this.securityService.kcService.login({
      redirectUri : window.location.origin
    });
    console.log(this.securityService.profile?.firstName)
  }

  onlogout() {
    this.securityService.kcService.logout(
      window.location.origin
    );
  }
}
