package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Student;

import java.util.List;

public interface CustomerModel {
    Customer save(Customer customer); // lưu thông tin.

    List<Customer> findAll();

    Customer findById(String customerID);

    Customer update(String customerID, Customer updateCustomer);

    boolean delete(String customerID);
}
