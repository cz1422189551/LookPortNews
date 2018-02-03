package com.cz.lookportnews.config;



import com.cz.lookportnews.config.filter.MyFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;
import java.io.IOException;

@PropertySource(
        value={"classpath:config/config.properties",
                "classpath:log4j.properties"}
        )
public class MyDispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

    //private static final Log LOG = LogFactory.getLog(MyDispatcherServlet.class);

    @Value("${tempFilePath}")
    private String tempFilePath;

    //加载根路径 RootConfig
    @Override
    protected Class<?>[] getRootConfigClasses() {
    //   LOG.debug("MyDispatcherServlet 加载 RootConfig[]文件");
        return new Class[]{RootConfig.class};
    }

    //加载Config
    @Override
    protected Class<?>[] getServletConfigClasses() {
//        LOG.debug("MyDispatcherServlet 加载 Servlet[] 文件");
        return new Class[]{WebConfig.class,ServiceConfig.class};
    }

    //映射路径
    @Override
    protected String[] getServletMappings() {
       // LOG.debug("MyDispatcherServlet 全局映射路径为 /");
        return new String[]{"/"};
    }



//    @Override
//    protected Filter[] getServletFilters() {
//        return new Filter[]{new MyFilter()};
//    }

}
