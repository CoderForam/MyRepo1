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
@WebServlet("/CompanyDetailsSave")  
public class CompanyDetailsSave extends HttpServlet {
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		
		PrintWriter pnt = resp.getWriter();

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
		//int i=lang.lastIndexOf(",");
		lang = lang.substring(0, lang.length()-1);
		
		String Gender = req.getParameter("Gender");
		String Blood_Group = req.getParameter("Blood_Group");
		
		CompanyDTO dto = new CompanyDTO();
		dto.setName(Name);
		dto.setEmail(Email);
		dto.setAddress(Address);
		dto.setCity(City);
		dto.setDate_of_Birth(Date_of_Birth);
		dto.setGender(Gender);
		dto.setLanguage(lang);
		dto.setBlood_Group(Blood_Group);
		

		int saveStatus = CompanyDAO.save(dto);
		if (saveStatus > 0) {
			pnt.print("Company Detail saved successfully");
			req.getRequestDispatcher("index.jsp").include(req, resp);
		} else {
			pnt.println("Sorry! Company Detail not save ");
		}
	}
}