package com.t2010a.hellot2010aagain.demo;

import com.t2010a.hellot2010aagain.entity.Student;
import com.t2010a.hellot2010aagain.model.InMemoryStudentModel;
import com.t2010a.hellot2010aagain.model.MySqlStudentModel;
import com.t2010a.hellot2010aagain.model.StudentModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    private static CustomerModel customerModel;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please choose type of model: ");
            System.out.println("--------------------------");
            System.out.println("1. In memory model.");
            System.out.println("2. My SQL model.");
            System.out.println("--------------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    customerModel = new InMemoryCustomerModel();
                    break;
                case 2:
                    customerModel = new MySqlCustomerModel();
                    break;
            }
            generateMenu();
        }
    }

    private static void generateMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------------Customer Manager--------------");
            System.out.println("1. Create new customer");
            System.out.println("2. Show all customer");
            System.out.println("3. Update customer");
            System.out.println("4. Delete customer");
            System.out.println("5. Exit");
            System.out.println("------------------------------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    createNewCustomer();
                    break;
                case 2:
                    showAllCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    System.out.println("Cya!");
                    break;
            }
            if (choice == 5) {
                break;
            }
        }
    }

    private static void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter customerID to update: ");
        String rollNumber = scanner.nextLine();
        Customer existingCustomer = customerModel.findById(customerID);
        if (existingCustomer == null) {
            System.err.println("404, Customer not found!");
        } else {
            if (customerModel.delete(customerID)) {
                System.out.println("Action success!");
            } else {
                System.err.println("Action fails, please try again!");
            }
        }
    }

    private static void updateCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter customerID to update: ");
        String rollNumber = scanner.nextLine();
        Customer existingCustomer = customerModel.findById(customerID);
        if (existingCustomer == null) {
            System.err.println("404, Customer not found!");
        } else {
            System.out.println("Please enter full name");
            String name = scanner.nextLine();
            existingCustomer.setFullName(name);
            if (customerModel.update(customerID, existingCustomer) != null) {
                System.out.println("Action success!");
            } else {
                System.err.println("Action fails, please try again!");
            }
        }
    }

    private static void showAllCustomer() {
        List<Customer> list = customerModel.findAll();
        for (customer customer :
                list) {
            System.out.println(customer.toString());
        }
    }

    private static void createNewCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter customer ID");
        String customerID = scanner.nextLine();
        System.out.println("Please enter full name");
        String name = scanner.nextLine();
        Customer customer = new Customer(customerID, name, "demo@gmail.com", "019231233", LocalDateTime.of(2000, 10, 10, 10, 10));
        if (customerModel.save(customer) != null) {
            System.out.println("Create customer success!");
        } else {
            System.err.println("Save customer fails, please try again later!");
        }
    }
}
