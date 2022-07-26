package com.java.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DAO.CompanyDAO;
import com.java.DTO.CompanyDTO;

@SuppressWarnings("serial")
@WebServlet("/ViewServlet")
public class ViewComapnyDetails extends HttpServlet{ 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();  
        out.println("<a href='index.jsp'>Add New Company</a>");  
        out.println("<h1>Company List</h1>");  
          
        List<CompanyDTO> list=CompanyDAO.getAllEmployees();  
        
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>id</th><th>Name</th><th>Email</th><th>Address</th><th>City</th><th>Gender</th><th>Date_Of_Birth</th><th>Language</th><th>Blood_Group</th><th>Edit</th><th>Delete</th></tr>");  
        for(CompanyDTO dto:list){  
        	 out.print("<tr><td>"+dto.getId()+"</td>"
        	 		+ "<td>"+dto.getName()+"</td>"
        	 		+ "<td>"+dto.getEmail()+"</td>"
        	 		+ "<td>"+dto.getAddress()+"</td>"
        	 		+ "<td>"+dto.getCity()+"</td>"
        	 		+ "<td>"+dto.getGender()+"</td>"
        	 		+ "<td>"+dto.getDate_of_Birth()+"</td>"
        	 		+ "<td>"+dto.getLanguage()+"</td>"
        	 		+ "<td>"+dto.getBlood_Group()+"</td>"
        	 		+ "<td><a href='EditServlet?id="+dto.getId()+"'>edit</a></td>"
        	 		+ "<td><a href='DeleteServlet?id="+dto.getId()+"'>delete</a></td></tr>");   
        }  
        out.print("</table>");  
          
        out.close();  
	}
}