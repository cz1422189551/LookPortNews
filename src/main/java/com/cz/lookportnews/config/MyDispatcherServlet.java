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

    @Override
    protected String getServletName() {

        return super.getServletName();
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new MyFilter()};
    }

    //    @Override
//    protected Filter[] getServletFilters() {
//        Filter[] filters = new Filter[]{new OpenSessionInViewFilter()};
//        System.out.println(filters.length);
//        return filters;
//    }

    //    @Override
//    protected void registerContextLoaderListener(ServletContext servletContext) {
//        super.registerContextLoaderListener(servletContext);
//    }
//
//    @Override
//    protected ApplicationContextInitializer<?>[] getRootApplicationContextInitializers() {
//        return super.getRootApplicationContextInitializers();
//    }
//
//    //自定义配置DispatchServlet的上传参数
//    @Override
//    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//
//        registration.setMultipartConfig(
//                //设置文件上传的临时目录
//                new MultipartConfigElement(
//                        tempFilePath
//                ,1024*1024*20,1024*1024*40,0)
//        );
//    }
}
