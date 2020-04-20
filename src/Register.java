import java.io.*;  
import java.sql.*;  

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
 
@WebServlet("/Register")
public class Register extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String userName=request.getParameter("userName");
String userFirstName=request.getParameter("firstName");
String userLastName=request.getParameter("lastName");
String userPass=request.getParameter("userPass");
String userEmail=request.getParameter("userEmail");
          
try{  

//Connection 	conn = DbConnection.getDbConnection("oracle");
Connection 	conn = DbConnection.getDbConnection("mysql");
int result = UsersTable.insertRecord(userName, userPass, userFirstName, userLastName, userEmail, conn);
if(result>0)  
out.print("You are successfully registered...");  
else
out.print("You are failed to register...");
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  