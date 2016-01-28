package com.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hansoljeong on 2015. 11. 14..
 */
public class First implements Servlet{
    ServletConfig config = null;

    public void init(ServletConfig config){
        this.config = config;
        System.out.println("servlet is initialized");
    }

    public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        System.out.print("<html><body>");
        System.out.print("<b>hello simple servlet</b>");
        System.out.print("</body></html>");
    }

    public void destroy(){
        System.out.println("servlet is destroyed");
    }

    public ServletConfig getServletConfig(){
        return config;
    }

    public String getServletInfo(){
        return "copyright 2007-1010";
    }
}
