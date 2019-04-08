package com.example.demo.Interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

public class FilterA implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter---------已启动！");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		System.out.println("filter 啦啦啦");
		/*
		 * if(!req.getRequestURI().equals("/login")) {
		 * if(StringUtils.isEmpty(req.getSession().getAttribute("user"))) {
		 * res.sendRedirect("/login"); }}
		 */
		if (req.getRequestURI().equals("/login")) {
			chain.doFilter(request, response);
			return ;
		}
		if (StringUtils.isEmpty(req.getSession().getAttribute("user"))) {
			res.sendRedirect("/login");
		}
		
		System.out.println("sss");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
