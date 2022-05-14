package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCustomerModelTest {

    InMemoryCustomerModel model;

    @BeforeEach
    void setUp() {
        model = new InMemoryCustomerModel();
    }

    @Test
    void save() {
        System.out.println(model.findAll().size());
        Customer customer = new Customer(
                "A005",
                "Xuan Hinh",
                "hinh@gmail.com",
                "091234555",
                LocalDateTime.of(2000, 10, 10, 0, 0)
        );
        model.save(customer);
        System.out.println(model.findAll().size());
    }

    @Test
    void findAll() {
        System.out.println(model.findAll().size());
    }

    @Test
    void findById() {
        Customer customer = model.findById("A001");
        System.out.println(customer.toString());
    }

    @Test
    void update() {
        Customer customer = model.findById("A001");
        customer.setFullName("Dao Xuan Hung");
        model.update("A001", customer);
        for (Customer st: model.findAll()) {
            System.out.println(st.toString());
        }
    }

    @Test
    void delete() {
        model.delete("A001");
        for (Customer st: model.findAll()) {
            System.out.println(st.toString());
        }
    }
}