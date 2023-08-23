import { SafeUrl } from "@angular/platform-browser"

export class foodproduct{

    productID?:number
    productname?:string
    image?:string
    description?:string
    price?:number
    sectionid?:string
    safeImageUrl: SafeUrl;
    
}