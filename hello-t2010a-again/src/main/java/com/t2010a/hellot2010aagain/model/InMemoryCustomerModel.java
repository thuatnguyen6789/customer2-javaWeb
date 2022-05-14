package com.t2010a.hellot2010aagain.model;


import com.t2010a.hellot2010aagain.entity.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerModel implements CustomerModel {

    private static List<Customer> customers;

    public InMemoryCustomerModel() {
        customers = new ArrayList<>();
        customers.add(
                new Customer(
                        "A001",
                        "Xuan Hung",
                        "xuanhung@gmail.com",
                        "0912345678",
                        LocalDateTime.of(2004, 10, 10, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        customers.add(
                new Customer(
                        "A002",
                        "Xuan Sang",
                        "xuansang@gmail.com",
                        "0912345679",
                        LocalDateTime.of(2004, 10, 10, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        customers.add(
                new Customer(
                        "A003",
                        "Xuan Thi",
                        "xuanthi@gmail.com",
                        "0912345679",
                        LocalDateTime.of(2004, 10, 10, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        customers.add(
                new Customer(
                        "A004",
                        "Xuan Dieu",
                        "xuandieu@gmail.com",
                        "0912345689",
                        LocalDateTime.of(2004, 10, 10, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
    }

    @Override
    public Customer save(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(String customerID) {
        Customer foundCustomer = null;
        for (Customer customer :
                customers) {
            if (customer.getcustomerID().equals(customerID)) {
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }

    @Override
    public Customer update(String customerID, Customer updateCustomer) {
        Customer existingCustomer = findById(customerID);
        if(existingCustomer == null){
            return null;
        }
        existingCustomer.setFullName(updateCustomer.getFullName());
        existingCustomer.setEmail(updateCustomer.getEmail());
        existingCustomer.setPhone(updateCustomer.getPhone());
        existingCustomer.setDob(updateCustomer.getDob());
        existingCustomer.setUpdatedAt(LocalDateTime.now());
        existingCustomer.setStatus(updateStudent.getStatus());
        return existingCustomer;
    }

    @Override
    public boolean delete(String customerID) {
        int foundIndex = -1;
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getcustomerID().equals(customerID)){
                foundIndex = i;
            }
        }
        if(foundIndex != -1){
            customers.remove(foundIndex);
            return true;
        }
        return false;
    }
}
