package com.lcpan.m04;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig(location = "C:/upload/")
@WebServlet("/UploadOneFile")
public class UploadOneFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part part = request.getPart("photo");
		// String filename = part.getSubmittedFileName();
		String filename = getFileName(part);
		part.write(filename);
	}
	
	private String getFileName(Part part) {
		String header = part.getHeader("Content-Disposition");
		int slashIdx = header.lastIndexOf("\\");
		String filename;
		if (slashIdx != -1)
			filename = header.substring(slashIdx + 1, header.length()-1);			
		else {
			int idx = header.indexOf("filename");
			filename = header.substring(idx + 10, header.length()-1);			
		}
		return filename;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
