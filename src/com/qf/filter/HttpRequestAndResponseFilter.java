package com.qf.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebFilter(filterName = "HttpRequestAndResponseFilter", urlPatterns = "/*")
public class HttpRequestAndResponseFilter implements Filter  {
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hreq  = (HttpServletRequest) req;
		String servletPath=hreq.getRequestURI();
		
		if(servletPath!=null&&servletPath.endsWith(".js")){
			rsp.setContentType("text/javascript; charset=utf-8");
			chain.doFilter(req, rsp);
		}else if(servletPath!=null&&servletPath.endsWith(".css")){
			rsp.setContentType("text/css; charset=utf-8");
			chain.doFilter(req, rsp);
		}
		
		chain.doFilter(req, rsp);
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
