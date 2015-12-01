package com.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns={"/jsp/fileUpload"})
@MultipartConfig(location="/Users/pey/Documents", maxFileSize=1024*1024*2)
public class FileUpload extends HttpServlet{
	
	private String getFilename(Part part){
		String contentDispositionHeader = part.getHeader("content-disposition"); 
		//contentDispositionHeader => form-data; name="filename"; filename="filename"
		
		String[] elements = contentDispositionHeader.split(";");
		for (String element : elements) {
			if (element.trim().startsWith("filename")){
				return element.substring(element.indexOf('=')+1).trim().replace("\"", "");
			}
		}
		return null;
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		Part part = request.getPart("filename");
		String filename = getFilename(part);
		if(filename != null && !filename.isEmpty()){
			part.write(filename);
		}
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("업로드한 파일 이름 : " + filename);
		writer.println("<br/>크기 : " + part.getSize());
		String author = new String(request.getParameter("author").getBytes("iso-8859-1"),"utf-8");
		writer.println("<br/>작성자 : " + author);
		
	}
}
