<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="javax.servlet.annotation.WebListener"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
<%@ page import="java.util.Random"%>
<%@ page import="java.io.PrintStream"%>
<%@ page import="java.util.*"%>

<%

int randomtemp=0;
Random random = new Random();


int desiredtemp=Integer.parseInt(request.getParameter("desiredtemp"));
 
System.out.println(desiredtemp);
for(int i =0; i<31556952; i++){
     randomtemp = random.nextInt(50);
     Thread.sleep(5000);
     
     
         
    
     System.out.println("Current reading from sensor " + randomtemp);
     
    
     
     
     
     if(randomtemp==desiredtemp){
    	 System.out.println("Desired Temperature");
    
     }
     else
     {
    	 randomtemp=desiredtemp;
    	 System.out.println("Updated temp to : " + randomtemp);
     }
     
}
    
     %>
     
     

</script>
<body>
     
     


     <p>Temprature Monitoring System</p>
    




     

        
        
        
        
</body>
</html>