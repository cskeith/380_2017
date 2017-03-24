package edu.ouhk.comps380f.filterexercise;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterB implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Entering FilterB.doFilter()");
        chain.doFilter(request, response);
        System.out.println("Leaving FilterB.doFilter()");
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
    }
}
