

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Feedback")
public class FeedbackServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		String feedbacker = req.getParameter("Email");
		String subject = req.getParameter("Subject");
		String message =req.getParameter("Comment");
		
		String [] recepients =new String[]{"c0761268@mylambton.ca","c0770339@mylambton.ca"};
		String [] bccRecepients =new String[]{feedbacker};
		SendEmail email_client = new SendEmail();
		PrintWriter out =res.getWriter();
		if (email_client.sendMail(recepients, bccRecepients, subject, message))
			out.println("Thank for your feedback. Your feedback is sent ");
		else
			out.println("Please try again! ");
	}

}
