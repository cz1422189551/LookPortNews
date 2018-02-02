package com.cz.lookportnews.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;

@Configuration
@EnableWebMvc // 开启SpringMvc配置
@ComponentScan(
        basePackages = "com.cz.lookportnews.controller")
public class WebConfig extends WebMvcConfigurerAdapter {



//    /**
//     * 设置Spring的文件上传解析器
//     * 不依赖Servlet3.0容器
//     * @return
//     * @throws IOException
//     */
//    @Bean
//    public CommonsMultipartResolver getCommonsMultipartResolver() throws IOException {
//        CommonsMultipartResolver multipartResolver =new CommonsMultipartResolver();
//
//        multipartResolver.setUploadTempDir(
//                new FileSystemResource(tempFilePath)
//        );
//        multipartResolver.setMaxUploadSize(1024*1024*2);
//        multipartResolver.setMaxInMemorySize(0);
//        return multipartResolver;
//    }


    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        return mappingJackson2HttpMessageConverter;
    }

    @Bean
    public StringHttpMessageConverter StringHttpMessageConverter(){
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        return stringHttpMessageConverter;
    }


//
//    /**
//     * 配置兼容Servlet3.0的 文件上传解析器
//     * 具体配置参数,在DispatchServlet中实现
//     */
//    @Bean
//    public StandardServletMultipartResolver  getStandardServletMultipartResolver(){
//        return new StandardServletMultipartResolver();
//    }






    /**
     * 配置jsp视图解析器
     * @return
     */
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resourceViewResolver =new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/WEB-INF/views/");
        resourceViewResolver.setSuffix(".jsp");
        resourceViewResolver.setExposeContextBeansAsAttributes(true);
        return resourceViewResolver;
    }

    /**
     * 使用默认的HandlerAdapter
     * 对静态资源实行懒加载
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
