import { UserService } from './user.service';
import { User } from './../models/user';

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {


  user: User = {userId: 0, role: "", password: "", email: "", username: "", isEnable: false};
  users: any

  constructor(public userService: UserService) { }

  ngOnInit(): void {
  }





}
