package cn.fq.filter;

import cn.fq.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆拦截器
 * */
public class SysFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}


	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("SysFilter doFilter()===========");
		HttpServletRequest rq = (HttpServletRequest)request;
		HttpServletResponse rp = (HttpServletResponse)response;
		User userSession = (User)rq.getSession().getAttribute("userSession");
		if(null == userSession){
			rp.sendRedirect(rq.getContextPath()+"/error.jsp");
		}else{
			chain.doFilter(request, response);
		}
	}

	public void destroy() {

	}

}
