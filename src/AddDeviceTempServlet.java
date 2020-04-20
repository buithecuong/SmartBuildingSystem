import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

import java.sql.*;

@WebServlet("/add_device_config")
public class AddDeviceTempServlet extends HttpServlet { 

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
   
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		// get request parameters for userID and password
		String device_id = request.getParameter("device_id");
		String temp = request.getParameter("temp");
		
		
		try {
			Connection 	conn = DbConnection.getDbConnection("mysql");
			int result = UpdateDeviceTempTable.AddDeviceTempRecord(device_id, temp, conn);
			if(result>0)  
				out.print("You are successfully added...");  
				else
				out.print("You are failed to added...");
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
		}  
   }
	
	
	

