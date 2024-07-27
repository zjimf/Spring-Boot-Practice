package com.practice.SpringBootPractice.Customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(){
       return customerService.getCustomers();
    }

    @PostMapping
    public void createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest){
        customerService.createCustomer(createCustomerRequest);
    }

    @PutMapping(path = "/{id}")
    public void updateCustomer(@PathVariable("id") Long id,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String email,
                               @RequestParam(required = false) String address){
        customerService.updateCustomer(id, name, email, address);
    }

    @DeleteMapping(path="/{id}")
    public void deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
    }
}
