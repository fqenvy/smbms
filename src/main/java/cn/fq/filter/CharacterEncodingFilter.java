package cn.fq.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    response.setCharacterEncoding("utf-8");
    request.setCharacterEncoding("utf-8");

    chain.doFilter(request,response);

    }

    public void destroy() {

    }
}
