package com.capgemini.bankapp.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.bankapp.exceptions.PayeeAccountNotFoundException;
import com.capgemini.bankapp.model.Customer;
import com.capgemini.bankapp.service.CustomerService;
import com.capgemini.bankapp.service.impl.CustomerServiceImpl;


@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerService customerService;
	private Customer customer;
	private ServletContext context;

    public LoginController() {
        super();
        customerService = new CustomerServiceImpl();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	context=config.getServletContext();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String customerId = request.getParameter("customerId");
		String password = request.getParameter("password");
	
		
	
		customer=new Customer(null, Integer.parseInt(customerId), password, null, null, null, null);
		HttpSession session=request.getSession();
		RequestDispatcher dispatcher = null;
		try {
			if((customer=customerService.authenticate(customer))!=null)
			{
			session.setAttribute("customer",customer);
			context.setAttribute("customerService", customerService);
			dispatcher = request.getRequestDispatcher("displayDetails.jsp");
			}
			else
			{
				dispatcher = request.getRequestDispatcher("userDoesNotExist.jsp");
			}
		} catch (PayeeAccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispatcher.forward(request, response);

	}

}