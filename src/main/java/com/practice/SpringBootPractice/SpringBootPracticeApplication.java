package com.practice.SpringBootPractice;

import com.practice.SpringBootPractice.Customer.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@SpringBootApplication
public class SpringBootPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPracticeApplication.class, args);
	}

	@GetMapping
	public List<Customer> getCustomers(){
		return List.of(new Customer("Jim","jmjmjim1101@gmail.com","Taiwan"));
	}

}
