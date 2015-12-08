package com.study.servlet;
import java.io.IOException;
import java.io.PrintWriter;
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
		
		final AsyncContext asyncContext = request.startAsync();//묵시적으로 요청과 응답 객체 처리
		System.out.println("isAsyncStarted? " + request.isAsyncStarted()); //비동기 처리가 시작됐는지 확인 
		asyncContext.start(new Runnable() {
			
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
					response.getWriter().println("====Async====");
				} catch (Exception e) {
					e.printStackTrace();	
				}
				
				System.out.println("====Async complete=====");
				try {
					response.getWriter().println("====Async complete=====");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				asyncContext.complete(); //client와 연결 종료 
			}
		});
		response.getWriter().println("====doGet end====");
		System.out.println("====doGet() end====");
	}
}
