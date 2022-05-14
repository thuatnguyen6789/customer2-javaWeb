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

public class EditCustomerServlet extends HttpServlet {

    private CustomerModel customerModel;

    public EditCustomerServlet() {
        this.customerModel = new MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy tham số customerID(id)
        String customerID = req.getParameter("id");
        // kiểm tra trong database xem có tồn tại không.
        Customer customer = customerModel.findById(customerID);
        // nếu không trả về trang 404
        if (customer == null) {
            req.setAttribute("message", "Customer not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            // nếu có trả về trang detail
            req.setAttribute("customer", customer);
            req.setAttribute("action", 2);
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
        String customerID = req.getParameter("customerID");
        Customer existingCustomer = customerModel.findById(customerID);
        if(existingCustomer == null){
            req.setAttribute("message", "Customer not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else{
            String fullName = req.getParameter("fullName");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String stringBirthday = req.getParameter("birthday");
            System.out.println(fullName);
            LocalDateTime birthday = DateTimeHelper.convertStringToLocalDateTime(stringBirthday);
            Customer customer = new Customer(customerID, fullName, email, phone, birthday);
            // validate dữ liệu
            if (customerModel.update(customerID, customer) != null) {
                resp.sendRedirect("/admin/customers/list");
            } else {
                // nếu có trả về trang form
                req.setAttribute("customer", customer);
                req.setAttribute("action", 2);
                req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
            }
        }
    }
}
