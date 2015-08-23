package com.hand.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.dao.CustomerDao;
import com.hand.dao.impl.CustomerDaoImpl;
import com.hand.entity.Customer;



public class edit_customer_fenlei extends HttpServlet {
	private CustomerDao productFenLeiDao = new CustomerDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idStr = req.getParameter("id");	
		Integer id = Integer.valueOf(idStr);
		List<Customer> productFenLei = productFenLeiDao.queryById(id);
		req.setAttribute("productFenLei", productFenLei);
		req.setAttribute("id",id);
		req.getRequestDispatcher("/edit_customer_fenlei.jsp").forward(req,resp);
		
	}
}
