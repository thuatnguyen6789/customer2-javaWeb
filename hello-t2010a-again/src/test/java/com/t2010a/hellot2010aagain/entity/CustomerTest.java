package com.t2010a.hellot2010aagain.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setcustomerID("A001");
        customer.setFullName("Xuan Hung");
        customer.setEmail("hung@gmail.com");
        customer.setPhone("091234567");
        customer.setDob(LocalDateTime.of(2004, 10, 22, 10, 10));
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());
        customer.setStatus(1);
        System.out.println(customer.toString());
    }

}