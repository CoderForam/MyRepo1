package com.java.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DAO.CompanyDAO;
import com.java.DTO.CompanyDTO;

@SuppressWarnings("serial")
@WebServlet("/EditServlet")
public class editservlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 resp.setContentType("text/html");  
	      
	        String sid=req.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	         
	        CompanyDTO e=CompanyDAO.getEmployeeById(id);  
	        req.setAttribute("e",e);
	        Map<String, String> userLanguage = new HashMap<String, String>();
	        if(e.getLanguage() != null) {
		        String lang[] = e.getLanguage().split(",");
		        for(String l1 : lang) {
		        	userLanguage.put(l1, l1);
		        }
	        }
	        req.setAttribute("langMap", userLanguage);
	        req.getRequestDispatcher("edit.jsp").include(req, resp);
	  
	}
	
}