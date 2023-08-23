import { Component } from '@angular/core';
import { User } from '../../model/User';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';


@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent {

  email?: string;
  upass?: string;
   
  data: User;
  matchingUser: User [] =[]

  constructor(private route: Router, private serv: RegistrationService)
  {}


  onSubmit() {
    const user: User = new User();
    user.emailId = this.email;
    user.password = this.upass;
  
    this.serv.loginUserFromRemote(user).subscribe(
      (res: User) => {
        console.log("Response from server:", res);
      //  this.data = res;
        this.route.navigate(['/organic']);
      },
      (error: any) => {
        console.log("error in login");
      }
    );
  }
  

}
