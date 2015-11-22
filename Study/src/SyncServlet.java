import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="SyncServlet", urlPatterns="/syncServlet")
public class SyncServlet extends HttpServlet{
	
	private static final long serialVersionUID = 222L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("====doGet() start====");
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.println("Hello");
		System.out.println("====doGet() end====");
	}
}
