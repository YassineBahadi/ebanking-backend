import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../services/customer.service';
import { JsonPipe } from '@angular/common';
import { Observable } from 'rxjs';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-customers',
  imports: [JsonPipe,AsyncPipe],
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit {
  customers!:Observable<any>;
  errorMessage!:HttpErrorResponse;

  constructor(private customerService:CustomerService){}

  ngOnInit(): void {
    this.customers=this.customerService.getCustomers();
  }

}
