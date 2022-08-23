import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent {
  public customer: Customer;
  public customerList: any;
  public isActive:boolean = true;
  public customerId: any;
  public mode:String = 'add';
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private customerService: CustomerService
  ) {
    this.customer = new Customer();
    if( this.route.routeConfig?.path == 'customers/edit/:id')
    {
      this.mode = 'edit';
      this.route.paramMap.subscribe(params => {
        this.customerId = params.get('id');
      });

      this.customerService.findById( this.customerId ).subscribe(result => {
        this.customer.id = result.id;
        this.customer.firstname = result.firstname;
        this.customer.lastname = result.lastname;
        this.customer.email = result.email;
        this.customer.phone = result.phone;
      });
    }
  }
  onSubmit() {

    console.log( this.mode );
    if( this.mode == 'edit' )
    {
      this.customerService.update(this.customer).subscribe(result => this.goToList());
    }

    if( this.mode == 'add')
    {
      this.customerService.save(this.customer).subscribe(result => this.goToList());
    }

  }

  goToList() {
    this.router.navigate(['/customers']);
  }

}
