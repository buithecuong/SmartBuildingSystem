

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Email")
public class EmailServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		String recepient = req.getParameter("email");
		String subject = req.getParameter("subject");
		String phone_number = req.getParameter("telephone");
		String message =req.getParameter("message") + "\n" + req.getParameter("name")+ "\n Phone Number:" + phone_number;
		
		String [] recepients =recepient.split(",");
		String [] bccRecepients =new String[]{"lambtoncollegeintoronto@gmail.com1"};
		SendEmail email_client = new SendEmail();
		PrintWriter out =res.getWriter();
		if (email_client.sendMail(recepients, bccRecepients, subject, message))
			out.println("Email is sent ");
		else
			out.println("Please try again! ");
	}

}
