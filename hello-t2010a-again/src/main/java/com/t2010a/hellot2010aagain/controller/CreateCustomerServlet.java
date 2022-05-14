package com.t2010a.hellot2010aagain.controller;

import com.t2010a.hellot2010aagain.entity.Customer;
import com.t2010a.hellot2010aagain.model.MySqlCustomerModel;
import com.t2010a.hellot2010aagain.model.CustomerModel;
import com.t2010a.hellot2010aagain.util.DateTimeHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class CreateCustomerServlet extends HttpServlet {

    private CustomerModel customerModel;

    public CreateCustomerServlet() {
        this.customerModel = new MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trả về form.
        req.setAttribute("customer", new Customer());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
        String customerID = req.getParameter("customerID");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String stringBirthday = req.getParameter("birthday");
        System.out.println(fullName);
        LocalDateTime birthday = DateTimeHelper.convertStringToLocalDateTime(stringBirthday);
        Customer customer = new Customer(customerID, fullName, email, phone, birthday);
        // validate dữ liệu
        if (customerModel.save(customer) != null) {
            resp.sendRedirect("/admin/customers/list");
        } else {
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
        }
    }
}
