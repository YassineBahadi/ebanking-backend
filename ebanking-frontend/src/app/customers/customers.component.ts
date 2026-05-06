import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../services/customer.service';
import { JsonPipe } from '@angular/common';

@Component({
  selector: 'app-customers',
  imports: [JsonPipe],
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit {
  customers:any;
  errorMessage!:HttpErrorResponse;

  constructor(private customerService:CustomerService){}

  ngOnInit(): void {
    this.customerService.getCustomers().subscribe({
      next:(data)=>{
        this.customers=data;
      },
      error:(err)=>{
        this.errorMessage=err;
      }
    })
  }

}
