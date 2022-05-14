package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Student;
import com.t2010a.hellot2010aagain.util.ConnectionHelper;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlCustomerModel implements CustomerModel {



    @Override
    public Customer save(Customer customer) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into customers " +
                    "(customerID, fullName, email, phone, dob, createdAt, updatedAt, status) " +
                    "values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, customer.getcustomerID());
            preparedStatement.setString(2, customer.getFullName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPhone());
            preparedStatement.setString(5, customer.getDob().toString());
            preparedStatement.setString(6, customer.getCreatedAt().toString());
            preparedStatement.setString(7, customer.getUpdatedAt().toString());
            preparedStatement.setInt(8, customer.getStatus());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from customers where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String customerID = resultSet.getString("customerID");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                LocalDateTime dob =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("dob").toInstant(), ZoneId.systemDefault());
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Customer customer = new Customer(customerID, fullName, email, phone, dob, createdAt, updatedAt, status);
                list.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Customer findById(String customerID) {
        Customer customer = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from customers where status = ? and customerID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, customerID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                LocalDateTime dob =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("dob").toInstant(), ZoneId.systemDefault());
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                customer = new Customer(customerID, fullName, email, phone, dob, createdAt, updatedAt, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer update(String customerID, Customer updateCustomer) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update customers " +
                    "set customerID = ?, fullName = ?, email = ?, phone = ?, dob = ?, createdAt = ?, updatedAt = ?, status = ? where rollNumber = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, updateCustomer.getcustomerID());
            preparedStatement.setString(2, updateCustomer.getFullName());
            preparedStatement.setString(3, updateCustomer.getEmail());
            preparedStatement.setString(4, updateCustomer.getPhone());
            preparedStatement.setString(5, updateCustomer.getDob().toString());
            preparedStatement.setString(6, updateCustomer.getCreatedAt().toString());
            preparedStatement.setString(7, updateCustomer.getUpdatedAt().toString());
            preparedStatement.setInt(8, updateCustomer.getStatus());
            preparedStatement.setString(9, customerID);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return updateCustomer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String customerID) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update customers " +
                    "set status = ? where customerID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, -1);
            preparedStatement.setString(2, customerID);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
