package com.practice.SpringBootPractice.Customer;

public record CreateCustomerRequest(String name,
                                    String email,
                                    String address) {
}
