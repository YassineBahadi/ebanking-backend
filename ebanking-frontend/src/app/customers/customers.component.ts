import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../services/customer.service';
import { JsonPipe } from '@angular/common';
import { catchError, Observable, throwError } from 'rxjs';
import { AsyncPipe } from '@angular/common';
import { Customer } from '../models/customer.model';
import { of } from 'rxjs';
import { FormBuilder, FormGroup ,ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-customers',
  imports: [JsonPipe,AsyncPipe,ReactiveFormsModule],
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit {

  customers!:Observable<Array<Customer>>;
  errorMessage!:string;
  loading=false;

  searchFormGroup:FormGroup | undefined;

  constructor(private customerService:CustomerService,private fb:FormBuilder){}

  ngOnInit(): void {
    this.searchFormGroup=this.fb.group({
      keyword:this.fb.control("")
    })

    this.loading=true;
    this.handleSearchCustomers();
  }

  handleSearchCustomers() {
    let kw=this.searchFormGroup?.value.keyword;
    this.customers=this.customerService.searchCustomers(kw).pipe(
      catchError(err=>{
        this.errorMessage = err.message;
          return of([]);
      })
    )
  }

}
