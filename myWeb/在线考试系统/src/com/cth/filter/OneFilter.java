package com.cth.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest) req;
        String uri = request.getRequestURI();
        System.out.println("uri="+uri);
        if(uri.equals("/myWeb/")||uri.equals("/myWeb/login")||uri.equals("/myWeb/index_errorLogin.html")){
            chain.doFilter(req, resp);
            return ;
        }
        HttpSession session = request.getSession(false);
        System.out.println("session="+session);
        if(session==null){
            HttpServletResponse response=(HttpServletResponse) resp;
            response.sendRedirect("/myWeb/index_errorLogin.html");
            return ;
        }
        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
