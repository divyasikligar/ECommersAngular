import { Injectable } from '@angular/core';
import { User } from '../model/User';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { skinproducts } from '../model/skinproducts';
import { foodproduct } from '../model/foodproduct';
import { DeliverInfoModel } from '../model/DeliverInfoModel';
import { cartdetails } from '../model/cartdetails';
import { cartdeliverydetails } from '../model/cartdeliverydetails';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http : HttpClient) { }

  public loginUserFromRemote(user:User):Observable<User>
  {
     return this.http.post<User>("http://localhost:8090/login",user);
  }

  public RegistrationUserFromRemote(user:User):Observable<User>
  {
     return this.http.post<User>("http://localhost:8090/registeruser",user);
  }

  public  getSkinProductDetails(): Observable<skinproducts[]>
  {
    return this.http.get<skinproducts[]>(`http://localhost:8090/skin`);
  }

  public  getFoodProductDetails(): Observable<foodproduct[]>
  {
    return this.http.get<foodproduct[]>(`http://localhost:8090/food`);
  }


  public  AddDeliveryData(dl:DeliverInfoModel):Observable<DeliverInfoModel>
  {
     return this.http.post<DeliverInfoModel>(`http://localhost:8090/delivery`,dl);
  }

  public getCartDetails(): Observable<cartdetails[]>
  {
    return this.http.get<cartdetails[]>(`http://localhost:8090/cartdetails`);
  }

  public putCartDetails(cd: cartdetails): Observable<cartdetails>
  {
    return this.http.post<cartdetails>(`http://localhost:8090/cartdetails`, cd);
  }

  public getCartDeliveryDetails(): Observable<cartdeliverydetails[]>
  {
    return this.http.get<cartdeliverydetails[]>(`http://localhost:8090/cartdeliverydetails`);
  }

}
