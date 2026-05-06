import { CustomerService } from './../services/customer.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ɵInternalFormsSharedModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { Customer } from '../models/customer.model';

@Component({
  selector: 'app-new-customer',
  imports: [ɵInternalFormsSharedModule,ReactiveFormsModule],
  templateUrl: './new-customer.component.html',
  styleUrl: './new-customer.component.css'
})
export class NewCustomerComponent implements OnInit{
  
  newCustomerFormGroup!: FormGroup;
  
  constructor(private fb:FormBuilder,private customerService: CustomerService){}
  

  ngOnInit(): void {
      this.newCustomerFormGroup=this.fb.group({
        name:this.fb.control(null),
        email:this.fb.control(null)
      });
  }

  handleSaveCustomer() {
      let customer:Customer=this.newCustomerFormGroup.value;
      this.customerService.saveCustomer(customer).subscribe({
        next:(data)=>{
          alert("customer has been successfully saved");
        },
        error:(err)=>{
          console.log(err);
        }
      })
  }
}
