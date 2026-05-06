import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { AccountService } from '../services/account.service';
import { Observable } from 'rxjs';
import { AccountDetails } from '../models/account.model';
import { AsyncPipe, DecimalPipe, NgClass , DatePipe } from '@angular/common';
@Component({
  selector: 'app-accounts',
  imports: [ReactiveFormsModule, AsyncPipe, DecimalPipe, DatePipe, NgClass],
  templateUrl: './accounts.component.html',
  styleUrl: './accounts.component.css'
})
export class AccountsComponent implements OnInit {

    accountFormGroup!:FormGroup;
    currentPage:number=0;
    pageSize:number=5;

    accountObservable!:Observable<AccountDetails>;


    constructor(private fb:FormBuilder,private accountService:AccountService){}

  ngOnInit(): void {
    this.accountFormGroup=this.fb.group({
      accountId:this.fb.control('')
    })
  }

  handleSearchAccount() {
    let accountId:string=this.accountFormGroup.value.accountId;
      this.accountObservable=this.accountService.getAccount(accountId,this.currentPage,this.pageSize);
  }

  gotoPage(page: number) {
      this.currentPage=page;
      this.handleSearchAccount();
  }

}
