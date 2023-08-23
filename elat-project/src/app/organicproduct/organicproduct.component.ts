import { Component, OnInit } from '@angular/core';

import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';

import { skinproducts } from '../../model/skinproducts';
import { foodproduct } from '../../model/foodproduct';
import {  cartdetails } from '../../model/cartdetails';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-organicproduct',
  templateUrl: './organicproduct.component.html',
  styleUrls: ['./organicproduct.component.css']
})
export class OrganicproductComponent implements OnInit  {

  selectedProduct: string | undefined
  
  data: foodproduct[] = [];
  skinprod: skinproducts[] = [];
  cart: cartdetails[] = [];
  selectedFile: File;
   

  constructor(private sanitizer: DomSanitizer,private serv: RegistrationService, private router: Router) { 

         
    this.serv.getSkinProductDetails().subscribe(
      (res : any[]) =>
       {
        // this.skinprod = res;

         // Convert base64 to Blob
      res.forEach(item => {
        item.safeImageUrl = this.getImageUrl(item.image); // Creating safeImageUrl        
    });
    this.skinprod = res;
        console.log(this.skinprod)
       },
       error => {console.error("error here")}
    );

    // After retrieving data from the API
this.serv.getFoodProductDetails().subscribe(
  (res: any[]) => {
      

      // Convert base64 to Blob
      res.forEach(item => {
        item.safeImageUrl = this.getImageUrl(item.image); // Creating safeImageUrl        
    });

    this.data = res;
    console.log(this.data);
          
  },
  error => {
      console.error("error here");
  }
);

   }
  

  
   submitProduct(selectedProduct: cartdetails) {
 
    this.serv.putCartDetails(selectedProduct).subscribe((res ) =>
    {
      console.log("here is responce" + res)
      this.router.navigate(['/delivery'])
    },
      error => console.error());

     };


  
  //   this.serv.Addorderdetails([dt]).subscribe(
  //     res => {
  //       console.log('Product order details added:', res);
  //     },
  //     error => {
  //       console.error('Error adding product order details:', error);
  //     }
  //   );
  
  //   this.router.navigate(['/productshow']);
  // }
  


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
  
      

      ngOnInit() {
  







        //Contact Section//

        // Get the elements by their IDs
        var firstNameInput = <HTMLInputElement>document.getElementById('firstname');
        var lastNameInput = <HTMLInputElement>document.getElementById('lastname');
        var submitButton = <HTMLInputElement>document.getElementById('submitBtn');
      
        // Add a click event listener to the submit button
        submitButton.addEventListener('click', () => {
          // Get the values from the input fields
          var firstName = firstNameInput.value;
          var lastName = lastNameInput.value;
      
          // Save the values to local storage
          localStorage.setItem('firstname', firstName);
          localStorage.setItem('lastname', lastName);
      
          // Optional: Display a confirmation message
          alert('First name and last name have been saved to local storage.');
      
          // Navigate to '/productshow' route
         // this.router.navigate(['/productshow']);
        });



        // Enquirey Section//

        var CustomerEmail = <HTMLInputElement>document.getElementById('CustomerEmail');
        var submitBtn2 = <HTMLInputElement>document.getElementById('submitBtn2');
         // Add a click event listener to the submit button

         submitBtn2.addEventListener('click', () =>
         {
          var emailvalue = CustomerEmail.value;
      
          // Save the values to local storage
          localStorage.setItem('CustomerEmail', emailvalue);
          alert("mail recieved");
         });



      }
      

      scrollTo(elementId: string) {
        const element = document.getElementById(elementId);
        if (element) {
          element.scrollIntoView({ behavior: 'smooth' });
        }
    }

    scrollToCart()
    {
      this.serv.getCartDetails().subscribe(
        (res : cartdetails[]) =>
        this.cart =res,
        error => 
        console.error("here is error")      
      );
      this.router.navigate(['/cart'])
    }
    
    searchTerm: string;
    filteredFoodItems = [];
    showSearchList: boolean = false;
    
    filterItems() {

      if (this.searchTerm.trim() !== '') {
      const matchedFoodItems = this.data.filter((item: foodproduct) => {
        return item.productname.toLowerCase().includes(this.searchTerm.toLowerCase());
      });
    
      const matchedSkinItems = this.skinprod.filter((item: skinproducts) => {
        return item.productname.toLowerCase().includes(this.searchTerm.toLowerCase());
      });
    
      this.filteredFoodItems = [...matchedFoodItems, ...matchedSkinItems];

    }
    
      if (this.filteredFoodItems.length > 0) {
        const sectionId = this.filteredFoodItems[0].sectionid;
        this.scrollTo(sectionId);
      }else {
        this.showSearchList = false; // Hide the search item list if no matching items
      }
    }

    scrollToFirstItem() {
      if (this.filteredFoodItems.length > 0) {
        const firstItemId = this.filteredFoodItems[0].sectionid;
        this.scrollTo(firstItemId);
      }
    }

    toggleSearchList() {
      this.showSearchList = !this.showSearchList;
    }
    




}
