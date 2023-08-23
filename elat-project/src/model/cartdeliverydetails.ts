import { SafeUrl } from "@angular/platform-browser";

export class cartdeliverydetails{

    cdid?:number;
	deliveryID?:number;
	address?:string;
	city?:string;
	pincode?:number;
	firstname?:string;
	lastname?:string;
	email?:string;
	pid?:number;
	productID?:number;
	cartid?:number;
	productname?:string;
	imagepath?:string;
    price?:number;
    safeImageUrl: SafeUrl;
}