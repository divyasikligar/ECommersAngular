import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { cartdeliverydetails } from '../../model/cartdeliverydetails';

@Component({
  selector: 'app-cartdeliverydetails',
  templateUrl: './cartdeliverydetails.component.html',
  styleUrls: ['./cartdeliverydetails.component.css']
})
export class CartdeliverydetailsComponent {

  data?: cartdeliverydetails[];

  constructor(private sanitizer: DomSanitizer,private serv: RegistrationService, private router: Router) { 

         
    this.serv.getCartDeliveryDetails().subscribe(
      (res : cartdeliverydetails[]) =>
      {
        res.forEach(item => {
          item.safeImageUrl = this.getImageUrl(item.imagepath); // Creating safeImageUrl        
      });
        this.data =res
        console.log("data"+ this.data)
        console.log("data"+ res)


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
}