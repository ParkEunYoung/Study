import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (name="AsyncServlet", urlPatterns={"/asyncServlet"}, asyncSupported=true)
public class AsyncServlet extends HttpServlet{
	
	private static final long serialVersionUID = 222L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("====doGet() start====");
		final AsyncContext asyncContext = request.startAsync();//비동기 객체 생성
		asyncContext.start(new Runnable() {//스레드 시작 
			
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (Exception e) {
					// TODO: handle exception
				}

				HttpServletResponse response = (HttpServletResponse)asyncContext.getResponse();
				response.setContentType("text/plain");
				response.setCharacterEncoding("UTF-8");
				
				try {
					response.getWriter().println("====async====");
				} catch (Exception e) {
					e.printStackTrace();	
				}
				System.out.println("====async complete=====");
				asyncContext.complete(); //client와 연결 종료 
			}
		});
		System.out.println("====doGet() end====");
	}
}
