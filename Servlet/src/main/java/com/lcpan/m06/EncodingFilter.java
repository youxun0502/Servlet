package com.lcpan.m06;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;


@WebFilter(urlPatterns="/EncodingFilterDemo",
		initParams=@WebInitParam(name="encoding", value="UTF-8") )
public class EncodingFilter extends HttpFilter implements Filter {
       String encoding = null;
 
	private static final long serialVersionUID = 1L;


	public EncodingFilter() {
        super();
      
    }


	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		// place your code here

		// pass the request along the filter chain
		if (encoding != null) {
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset=" + encoding);
			;
		}
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	  encoding = fConfig.getInitParameter("encoding");
	}

}
