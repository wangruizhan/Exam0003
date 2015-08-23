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
import com.hand.util.PageUtils;

public class check_customer_fenlei extends HttpServlet {
	private CustomerDao customerDao = new CustomerDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String search = req.getParameter("search");
		//System.out.println("!!!!!!!!!"+search);
		List<Customer> list = null;
		if(search!=null && !search.isEmpty()){
			list = customerDao.query(search);
		}
		 long totalcount =customerDao.count(); 
		 long totalpage = PageUtils.checkTotalcount(totalcount);
		long page = 1;
		try {
			  page = Integer.parseInt(req.getParameter("page"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}	
		 page = PageUtils.checkpage(page,totalpage);
		long size = PageUtils.checksize();
		
		 List<Customer> Customer = customerDao.query(page,size);
		
		 req.setAttribute("totalpage", totalpage);
		 req.setAttribute("search", list);
		 req.setAttribute("page", page);
		 req.setAttribute("customer", Customer);
		 req.getRequestDispatcher("/WEB-INF/back/fenlei_list.jsp").forward(req,resp);
		
	}
	

}
