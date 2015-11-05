package spring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SimpleServlet extends HttpServlet {

	  @Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  User user = new User();
		  req.setAttribute("user", user);
		  req.getRequestDispatcher("hello.jsp").forward(req, res);
	  }
  
}
