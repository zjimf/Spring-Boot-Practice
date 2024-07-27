package com.practice.SpringBootPractice.Customer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {
    private  final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }


    public void createCustomer(CreateCustomerRequest createCustomerRequest){
        Optional<Customer> customerByEmail = customerRepository.findByEmail(createCustomerRequest.email());
        if(customerByEmail.isPresent()){
            throw new RuntimeException("The email unavailable");
        }
        Customer customer = Customer.create(createCustomerRequest.name(),
                createCustomerRequest.email(),
                createCustomerRequest.address());

        customerRepository.save(customer);
    }

    public void updateCustomer(Long id,String name,String email,String address){
        Customer customer = customerRepository.findById(id).orElseThrow(()->
                new RuntimeException("Customer with "+id+"not found"));


        if(Objects.nonNull(name)&&!Objects.equals(customer.getName(),name)){
            customer.setName(name);
        }
        if(Objects.nonNull(email)&&!Objects.equals(customer.getEmail(),email)){
            Optional<Customer> customerByEmail = customerRepository.findByEmail(email);
            if(customerByEmail.isPresent()) {
                throw new RuntimeException("The email unavailable");
            }
        }
        if(Objects.nonNull(address)&&!Objects.equals(customer.getAddress(),address)){
            customer.setAddress(address);
        }

        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);

        customerRepository.save(customer);
    }


    public void deleteCustomer(Long id) {
        boolean isExist = customerRepository.existsById(id);

        if(!isExist){
            throw new RuntimeException(String.format("Customer %s not exist",id));
        }
        customerRepository.deleteById(id);
    }
}
