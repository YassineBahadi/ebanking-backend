import { CustomerService } from './../services/customer.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ɵInternalFormsSharedModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { Customer } from '../models/customer.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-customer',
  imports: [ɵInternalFormsSharedModule,ReactiveFormsModule],
  templateUrl: './new-customer.component.html',
  styleUrl: './new-customer.component.css'
})
export class NewCustomerComponent implements OnInit{
  
  newCustomerFormGroup!: FormGroup;
  
  constructor(private fb:FormBuilder,private customerService: CustomerService,private router:Router){}
  

  ngOnInit(): void {
      this.newCustomerFormGroup=this.fb.group({
        name:this.fb.control(null,[Validators.required,Validators.minLength(4)]),
        email:this.fb.control(null,[Validators.required,Validators.email])
      });
  }

  handleSaveCustomer() {
      let customer:Customer=this.newCustomerFormGroup.value;
      this.customerService.saveCustomer(customer).subscribe({
        next:(data)=>{
          alert("customer has been successfully saved");
          // this.newCustomerFormGroup.reset();
          this.router.navigateByUrl("/customers");
        },
        error:(err)=>{
          console.log(err);
        }
      })
  }
}
