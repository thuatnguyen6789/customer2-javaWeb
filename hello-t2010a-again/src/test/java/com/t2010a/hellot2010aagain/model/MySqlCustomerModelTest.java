package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlCustomerModelTest {

    CustomerModel model;

    @BeforeEach
    void setUp() {
        model = new MySqlCustomerModel();
    }

    @Test
    void save() {
        model.save(new Customer("A003", "Hong", "hong@gmail.com", "0123123132", LocalDateTime.of(2004, 10, 10, 10, 10)));
    }

    @Test
    void findAll() {
        List<Customer> list = model.findAll();
        for (Customer st :
                list) {
            System.out.println(st.toString());
        }
    }

    @Test
    void findById() {
        Customer customer = model.findById("A001");
        assertEquals("Hung", customer.getFullName());
        Customer customer1 = model.findById("A002");
        assertEquals("Luyen", customer1.getFullName());
    }

    @Test
    void update() {
        Customer customer = model.findById("A001");
        customer.setFullName("Xuan Van Hung");
        model.update("A001", student);
        Customer newUpdateCustomer = model.findById("A001");
        assertEquals("Xuan Van Hung", newUpdateCustomer.getFullName());
    }

    @Test
    void delete() {
        model.delete("A001");
        Customer customer = model.findById("A001");
        assertEquals(null, customer);
    }
}