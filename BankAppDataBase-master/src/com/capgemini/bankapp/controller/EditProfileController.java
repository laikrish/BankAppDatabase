package com.capgemini.bankapp.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.bankapp.model.Customer;
import com.capgemini.bankapp.service.CustomerService;


@WebServlet("/editProfile.do")
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	private CustomerService customerService;
    public EditProfileController() {
        super();
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		customerService = (CustomerService) context.getAttribute("customerService");
		HttpSession session = request.getSession();
		
		
		String email = request.getParameter("email");
		String Address = request.getParameter("address");
		Customer customerMapper = (Customer) session.getAttribute("customer");

		Customer customerEditted = new Customer(null, customerMapper.getCustomerId(), null, null, null, null, null);

		customerEditted.setAddress(Address);
		customerEditted.setEmail(email);
		

		customerService.updateProfile(customerEditted);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("profileUpdatedSuccessfully.jsp");
		dispatcher.forward(request, response);
		
		
		
	
	}

}