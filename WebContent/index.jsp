<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.File"%>
<%@page import="java.io.*" %>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="com.CaptchaImage"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Captcha</title>
</head>
<body>

<%
response.setContentType("image/jpg");
 String result = "Invalid Entry.... :(";
 String color = "red";
 if(request.getParameter("captcha") != null && session.getAttribute("captchaStr") != null){
  if(session.getAttribute("captchaStr").equals(request.getParameter("captcha"))){
   result = "Valid Entry.... :)";
   color = "green";
  }
 }

 CaptchaImage obj = new CaptchaImage();
 BufferedImage ima = obj.getCaptchaImage();
// OutputStream osImage = response.getOutputStream();
 /* File outputfile = new File(request.getContextPath()+"/resources/captcha.jpeg");
 ImageIO.write(ima, "jpeg", outputfile); */
 //osImage.close();
 String captchaStr = obj.getCaptchaString();
 
 session.setAttribute("captchaStr", captchaStr);

%>


<form action="index.jsp" method="post">
 <table>
 <!--  <tr>
   <td><img alt="Captcha" src="D://Foram/captcha.jpg" height="20%" width="20%" align="top" /> </td>
  </tr> -->
  <tr>
   <td> <input type="text" value="" name="captcha"> </td>
  </tr>
  <tr>
   <td> <input type="submit" value="Submit"> </td>
  </tr>
  <tr>
   <td> <font color="<%=color%>">Value : <%= result %></font></td>
  </tr>
 </table>
</form>

</body>
</html>