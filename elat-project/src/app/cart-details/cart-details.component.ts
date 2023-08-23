import { Component } from '@angular/core';
import {cartdetails } from '../../model/cartdetails';
import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';

import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css']
})
export class CartDetailsComponent {

  data?: cartdetails[];


  constructor(private sanitizer: DomSanitizer,private serv : RegistrationService, private route : Router){

    serv.getCartDetails().subscribe(
      (res : cartdetails[]) =>
      {
        res.forEach(item => {
          item.safeImageUrl = this.getImageUrl(item.imagepath); // Creating safeImageUrl        
      });
        this.data =res

    },
     
      error => 
      console.error("here is error")      
    );


  }

  
// Helper function to convert base64 to Blob
base64toBlob(base64Data: string, contentType: string): Blob {
  const sliceSize = 512;
  const byteCharacters = atob(base64Data);
  const byteArrays = [];

  for (let offset = 0; offset < byteCharacters.length; offset += sliceSize) {
      const slice = byteCharacters.slice(offset, offset + sliceSize);

      const byteNumbers = new Array(slice.length);
      for (let i = 0; i < slice.length; i++) {
          byteNumbers[i] = slice.charCodeAt(i);
      }

      const byteArray = new Uint8Array(byteNumbers);
      byteArrays.push(byteArray);
  }

  return new Blob(byteArrays, { type: contentType });
}


  getImageUrl(imageData: string): SafeUrl {
    const blob = this.base64toBlob(imageData, 'image/jpeg'); // Adjust content type if needed
    const url = URL.createObjectURL(blob);
    return this.sanitizer.bypassSecurityTrustUrl(url);
  }
  

  submitorder(a : cartdetails){}

}
