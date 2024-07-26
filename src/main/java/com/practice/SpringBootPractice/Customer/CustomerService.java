package com.practice.SpringBootPractice.Customer;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
    private  final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return List.of(new Customer("Jim","jmjmjim1101@gmail.com","Taiwan"));
    }

}
