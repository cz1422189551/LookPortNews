package com.cz.lookportnews.config.filter;//package com.qzxy.config.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(
        urlPatterns="/*",
        filterName="myFilter",
        dispatcherTypes= DispatcherType.REQUEST
//        initParams=
//        @WebInitParam(name="nologinpath",value=".css;.js;.img;.gif;.jpg;.png;login_index.jsp;LoginServlet;fail.jsp;")
)
public class MyFilter implements Filter {



    //过滤配置
    private FilterConfig config;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("请求 :"+ request.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
