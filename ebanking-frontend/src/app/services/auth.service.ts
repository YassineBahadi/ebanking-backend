import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { jwtDecode } from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  backendHost:string="http://localhost:8085"
  isAuthenticated:boolean=false;
  roles:any;
  username:any;
  accessToken!:string;

  constructor(private http:HttpClient) { }

  public login(username:string,password:string){
    let options={
      headers:new HttpHeaders().set("Content-Type","application/x-www-form-urlencoded"),
    }
    let params=new HttpParams()
        .set("username",username).set("password",password);
    return this.http.post(this.backendHost+"/auth/login",params,options)
  }

  loadProfile(data: any) {
    this.isAuthenticated=true;
    this.accessToken=data['access-token'];
    let decodedJwt:any=jwtDecode(this.accessToken);
    this.username=decodedJwt.sub;
    this.roles=decodedJwt.scope;
  }

}
