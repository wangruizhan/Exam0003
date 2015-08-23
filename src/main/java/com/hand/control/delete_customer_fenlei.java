package com.hand.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.dao.CustomerDao;
import com.hand.dao.impl.CustomerDaoImpl;



public class delete_customer_fenlei extends HttpServlet {
	private CustomerDao customerDao = new CustomerDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			String[] idArr = req.getParameterValues("id");	
			for(String idStr:idArr){
			Integer id = Integer.valueOf(idStr);
			customerDao.delete(id);
			}
			req.setAttribute("msg", "¹§Ï²Äã£¬É¾³ý³É¹¦");
			req.setAttribute("nextUrl", "/back/chprfl");
			req.getRequestDispatcher("/gobal-msg.jsp").forward(req,resp);
	}
}
