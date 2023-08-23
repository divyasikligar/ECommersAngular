import { Component, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginpageComponent } from './loginpage/loginpage.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { OrganicproductComponent } from './organicproduct/organicproduct.component';
import { RouterModule } from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';
import { HttpClientModule } from '@angular/common/http';
import { DeliveryInfoComponent } from './delivery-info/delivery-info.component';
import { CartDetailsComponent } from './cart-details/cart-details.component';
import { CartdeliverydetailsComponent } from './cartdeliverydetails/cartdeliverydetails.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginpageComponent,
    OrganicproductComponent,
    RegistrationComponent,
    DeliveryInfoComponent,
    CartDetailsComponent,
    CartdeliverydetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path:'admin', component:LoginpageComponent},
      {path:'organic', component:OrganicproductComponent},
      {path:'registration',component:RegistrationComponent},
      {path:'delivery',component:DeliveryInfoComponent},
      {path:'cart',component:CartDetailsComponent},
      {path:'cartdelivery',component:CartdeliverydetailsComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
