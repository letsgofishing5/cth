package com.cth.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class OneFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        String requestURI = request.getRequestURI();
        if(requestURI.equals("/myWeb/") || requestURI.equals("/myWeb/Login")){
            chain.doFilter(req,resp);
        }
        HttpSession session = request.getSession(false);
        if(session==null){
            HttpServletResponse response=(HttpServletResponse)resp;
            PrintWriter writer = response.getWriter();
            response.sendRedirect("/myWeb/errorLogin.html");

        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
