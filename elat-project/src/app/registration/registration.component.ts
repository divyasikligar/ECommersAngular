import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {


  submitted=false;

  constructor(private frmbuild: FormBuilder, private serv:RegistrationService, private router:Router){}

 registerform: FormGroup = new FormGroup({
    firstNm: new FormControl(),
    lastnm: new FormControl(),
    email: new FormControl(),
    pass: new FormControl()
  })

  ngOnInit(){

   this.registerform = this.frmbuild.group({ 

      firstNm: ['', Validators.required],
      lastnm: ['', Validators.required],
      email: ['', [Validators.required,Validators.email]],
      pass: ['', [Validators.required,Validators.maxLength(5)]]

    }); 

  }

  registerinfo(){
    this.submitted =true; 

    const obj = {emailId:this.registerform.get('email').value, 
               userName:this.registerform.get('firstNm').value,
               password:this.registerform.get('pass').value}

    

    if(this.registerform.invalid)
    {
      return;
    }else
    {
       this.serv.RegistrationUserFromRemote(obj).subscribe(res =>
         {console.log("Added Record" + res)
         this.router.navigate(['/admin']);
        },
         error =>{
          console.error("error here");
          //alert("user already exists")
         } );
       
        
    }


  }


  get Getcontrol() : {[m:string]: AbstractControl}
  {
    return this.registerform.controls;
  }
 
 

}

