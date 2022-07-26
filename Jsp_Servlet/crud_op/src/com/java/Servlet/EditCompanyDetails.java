package com.java.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DAO.CompanyDAO;
import com.java.DTO.CompanyDTO;

@SuppressWarnings("serial")
@WebServlet("/EditServlet2")
public class EditCompanyDetails extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		 String sid=req.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	        System.out.println("id in editservlet2--------" + id);
	        String Name = req.getParameter("Name");
			String Email = req.getParameter("Email");
			String Address = req.getParameter("Address");
			String City = req.getParameter("City");
			String Date_of_Birth = req.getParameter("Date_of_Birth");
			String Language[] = req.getParameterValues("Language");
			String lang = "";
			for(String a: Language) {
				lang=lang.concat(a).concat(",");
			}
			
			lang = lang.substring(0, lang.length()-1);
			
			String Gender = req.getParameter("Gender");
			String Blood_Group = req.getParameter("Blood_Group");
			
			CompanyDTO dto = new CompanyDTO();
			dto.setId(id);
			dto.setName(Name);
			dto.setEmail(Email);
			dto.setAddress(Address);
			dto.setCity(City);
			dto.setDate_of_Birth(Date_of_Birth);
			dto.setGender(Gender);
			dto.setLanguage(lang);
			dto.setBlood_Group(Blood_Group);
			System.out.println(dto);
	        int cmpDstatus=CompanyDAO.update(dto);  
	        if(cmpDstatus>0){  
	        	out.println("Company Details updated successfully");
	            resp.sendRedirect("ViewServlet");  
	        }else{  
	            out.println("Sorry! Company Details Not Updated.");  
	        }  
	          
	        out.close();  
	}
}