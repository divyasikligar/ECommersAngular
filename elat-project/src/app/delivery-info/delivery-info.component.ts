import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { DeliverInfoModel } from '../../model/DeliverInfoModel';

@Component({
  selector: 'app-delivery-info',
  templateUrl: './delivery-info.component.html',
  styleUrls: ['./delivery-info.component.css']
})
export class DeliveryInfoComponent {
  dl: DeliverInfoModel[] = [];
  email?:string
  pincode?:number
  address?:string
  firstname?:string
  lastname?:string
  city?:string
  phone?:string


  constructor(private serv: RegistrationService, private router: Router) {
   
  }
  onConfirm()
  {
    let obj = {email:this.email, pincode:this.pincode, address:this.address, firstname:this.firstname, 
      lastname:this.lastname, city:this.city, phone:this.phone}
    this.serv.AddDeliveryData(obj).subscribe(
      res =>
        {console.log("Added Record" + res)
        alert("order confirm")
        this.router.navigate(['/cartdelivery'])
      },
        error => console.error("error here"));
  }
  

}
