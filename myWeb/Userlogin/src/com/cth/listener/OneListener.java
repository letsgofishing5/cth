package com.cth.listener;

import com.cth.myUtil.JDBCUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OneListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public OneListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        Connection con=null;
        Map map = new HashMap<>();
        for(int i=0;i<20;i++){
            Date statDate = new Date();
            con= JDBCUtil.getConnection();
            Date endDate = new Date();
            System.out.println("创建数据库--->"+i+"连接花费时间="+(endDate.getTime()-statDate.getTime())+"毫秒");
            System.out.println("数据库创建-->："+i+con);
            map.put(con,true);
        }
        ServletContext application = sce.getServletContext();
        application.setAttribute("key",map);


    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        Map map = (Map)application.getAttribute("key");
        Iterator iterator  = map.keySet().iterator();

        while (iterator.hasNext())
        {
            Connection con = (Connection)iterator.next();
            if (con != null) {
                System.out.println("数据库："+con+"关闭");
                JDBCUtil.close(null,null,con);
            }

        }

    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attribute
         is replaced in a session.
      */
    }
}
