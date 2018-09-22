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


@WebServlet("/changePassword.do")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	private CustomerService customerService;
       

    public ChangePasswordController() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	context = config.getServletContext();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmNewPassword = request.getParameter("confirmNewPassword");
		
		
		HttpSession session = request.getSession();
		customerService = (CustomerService) context.getAttribute("customerService");
		
		if(newPassword.equals(confirmNewPassword))
		{
			if(customerService.updatePassword((Customer) session.getAttribute("customer"), oldPassword, confirmNewPassword))
			{
				
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("passwordSuccesfullyChanged.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		
	}

}