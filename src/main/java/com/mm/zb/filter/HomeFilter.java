package com.mm.zb.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Creat by ZB
 * 2019-02-23 2:17
 */
@Component
@WebFilter(urlPatterns = "/*", filterName = "HomeFilter")
public class HomeFilter implements Filter {


    @Override
    public void init(FilterConfig fislterConfig) throws ServletException {
        System.out.println("666");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        int t = 0;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userId")) {
                    t++;
                }
            }
        }
        if (t == 0) {
            Cookie cookie = new Cookie("userId", "0");
            HttpServletResponse response1 = (HttpServletResponse) response;
            response1.addCookie(cookie);
            ((HttpServletResponse) response)
                    .sendRedirect("/user/home/list");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
