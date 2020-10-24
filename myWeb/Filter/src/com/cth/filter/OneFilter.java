package com.cth.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class OneFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        String age = req.getParameter("age");
        if(Integer.valueOf(age)<60){
            chain.doFilter(req, resp);
        }else{
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.print("<center><font style='color:red;font-size:40px;'>不可访问</font></center>");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
