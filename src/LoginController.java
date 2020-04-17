import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class LoginController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String user = request.getParameter("username");
      String pwd = request.getParameter("pass");
      if (user.equals("c0770339")) {
         out.print("Welcome, " + user);
         HttpSession session = request.getSession(true); // reuse existing
                                             // session if exist
                                             // or create one
         session.setAttribute("user", user);
         session.setMaxInactiveInterval(30); // 30 seconds
         response.sendRedirect("home.jsp");
      } else {
         RequestDispatcher rd = request.getRequestDispatcher("login.html");
         out.println("<font color=red>Either user name or password is wrong.</font>");
         rd.include(request, response);
      } // TODO Auto-generated method stub
   }
}