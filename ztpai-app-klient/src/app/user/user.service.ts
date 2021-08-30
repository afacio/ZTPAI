import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService implements OnInit{

  usersList: any;

  constructor(private http: HttpClient) {
    this.readUsers();
   }

  ngOnInit(){
  }

  readUsers(){
    console.log(" readUsers ")
    this.http.get("http://localhost:8080/api/user/getUser").subscribe(data => {
      this.usersList=data
    });

  }

  getUsers(){
    console.log(" getUsers ")
    return this.usersList;
  }

  getUserById(userId: number){
    console.log(" getUserById ")
    this.http.get("http://localhost:8080/api/user/getUser/" + userId).subscribe(data => {
      this.usersList=data
    });
  }

}
