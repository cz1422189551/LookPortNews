package com.cz.lookportnews.config.filter;//package com.qzxy.config.filter;

import com.cz.lookportnews.entity.admin.Admin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        urlPatterns="/*",
        filterName="myFilter",
        dispatcherTypes= DispatcherType.REQUEST
//        initParams=
//        @WebInitParam(name="nologinpath",value=".css;.js;.img;.gif;.jpg;.png;login.jsp;login;fail.jsp;")
)
public class MyFilter implements Filter {



    private static final String REGEX="login_out.png;.css;.js;.img;.gif;.jpg;.png;login.jsp;login;fail.jsp;font;";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest =(HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse =(HttpServletResponse) servletResponse;
        HttpSession session =httpRequest.getSession();
        httpRequest.setCharacterEncoding("utf-8");
        httpRequest.setCharacterEncoding("utf-8");
//        System.out.println(httpRequest.getRequestURI());

        String[] params=REGEX.split(";");
        for(String s: params)
        {

            //请求无需验证登陆的页面：login.jsp 和fail.jsp则，直接放行
            if(httpRequest.getRequestURI().contains(s))
            {
//                System.out.println(s);
                filterChain.doFilter(httpRequest, httpResponse);
                return ;
            }
        }

        Admin admin =(Admin) session.getAttribute("admin");
        if(admin!=null){
            filterChain.doFilter(httpRequest, httpResponse);
        } else
        {
//            System.err.println("Session过期重新登陆");
            httpResponse.sendRedirect(httpRequest.getContextPath()+"/login.jsp");
        }

    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
