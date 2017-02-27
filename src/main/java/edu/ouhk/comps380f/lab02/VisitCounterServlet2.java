package edu.ouhk.comps380f.lab02;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VisitCounterServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        Integer count = null;
        synchronized (context) {
            count = (Integer) context.getAttribute("counter");
            if (count == null) {
                count = new Integer(1);
            } else {
                count = new Integer(count.intValue() + 1);
            }
            context.setAttribute("counter", count);
        }
        ServletConfig config = this.getServletConfig();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append(" <head>\r\n")
                .append(" <title>").append(config.getInitParameter("title")).append("</title>\r\n")
                .append(" </head>\r\n")
                .append(" <body>\r\n")
                .append("<h1>").append(config.getInitParameter("title")).append("</h1>\r\n")
                .append(" The site ").append(context.getInitParameter("title"))
                .append(" was visited for " + count + " times.\r\n")
                .append(" </body>\r\n")
                .append("</html>\r\n");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started.");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped.");
    }
}
