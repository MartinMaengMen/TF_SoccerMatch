import { Component } from '@angular/core';
import { AuthService } from './_service/auth-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  id: number
  constructor(private authService : AuthService) { }

  ngOnInit() {
    this.id = Number(this.authService.getToken());
  }
}
