import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  devEmployees: any;
  testEmployees: any;
  devopsEmployees: any;

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.findAllByRole('dev').subscribe(data => {
      this.devEmployees = data;
    });

    this.employeeService.findAllByRole('test').subscribe(data => {
      this.testEmployees = data;
    });

    this.employeeService.findAllByRole('devops').subscribe(data => {
      this.devopsEmployees = data;
    });
  }
}