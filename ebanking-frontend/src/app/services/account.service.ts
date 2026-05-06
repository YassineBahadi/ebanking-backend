import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
// import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { AccountDetails } from '../models/account.model';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

    backendHost:string="http://localhost:8085"

  constructor(private http:HttpClient) { }

  public getAccount(accountId:string,page:number,size:number):Observable<AccountDetails>{
    return this.http.get<AccountDetails>(this.backendHost+"/accounts/"+accountId+"/pageOperations?page="+page+"&size="+size);
  }
}
