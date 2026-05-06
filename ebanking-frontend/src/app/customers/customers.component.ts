import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../services/customer.service';
import { JsonPipe } from '@angular/common';
import { catchError, Observable, throwError } from 'rxjs';
import { AsyncPipe } from '@angular/common';
import { Customer } from '../models/customer.model';
import { of } from 'rxjs';

@Component({
  selector: 'app-customers',
  imports: [JsonPipe,AsyncPipe],
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit {
  customers!:Observable<Array<Customer>>;
  errorMessage!:string;

  loading=false;

  constructor(private customerService:CustomerService){}

  ngOnInit(): void {
    this.loading=true;
    this.customers=this.customerService.getCustomers().pipe(
      catchError(err=>{
          this.errorMessage = err.message;
          return of([]);
      })
    );
  }

}
