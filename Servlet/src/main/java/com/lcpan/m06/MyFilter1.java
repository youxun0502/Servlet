package com.lcpan.m06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("/FilterDemo")
public class MyFilter1 extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;


	public MyFilter1() {
        super();
     
    }


	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		// place your code here

		// pass the request along the filter chain
		PrintWriter out = response.getWriter();
		out.write("Pre-processing of MyFilter1<br>");
		chain.doFilter(request, response);
		out.write("Post-processing of MyFilter1<br>");
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
