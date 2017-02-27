<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%!
    public void jspInit() {
        System.out.println("JSP servlet " + this.getServletName() + " has started.");
    }

    public void jspDestroy() {
        System.out.println("JSP servlet " + this.getServletName() + " has stopped.");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title><%= config.getInitParameter("title")%></title>
    </head>
    <body>
        <jsp:useBean id="visit" scope="application" 
                 class="edu.ouhk.comps380f.lab03.VisitCounter" />
        <jsp:setProperty name="visit" property="count" 
                                     value='<%= visit.getCount() + 1 %>'/>
        <h1><%= config.getInitParameter("title")%></h1>
        The site <%= application.getInitParameter("title") %>
        was visited for <jsp:getProperty name="visit" property="count" /> 
        times.
    </body>
</html>
