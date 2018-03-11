package com.cz.lookportnews.config;

import com.cz.lookportnews.config.interceptor.LoginInterceptor;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import sun.rmi.runtime.Log;

import java.io.IOException;

@Configuration
@EnableWebMvc // 开启SpringMvc配置
@ComponentScan(
        basePackages = "com.cz.lookportnews.controller")
public class WebConfig extends WebMvcConfigurerAdapter {


    @Bean
    public CommonsMultipartResolver getCommonsMultipartResolver(){
        CommonsMultipartResolver multipartResolver =new CommonsMultipartResolver();
       multipartResolver.setDefaultEncoding("utf-8");
        multipartResolver.setMaxUploadSize(1024*1024*4);
        multipartResolver.setMaxInMemorySize(1024*1024*4);
        return multipartResolver;
    }



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

    @Bean
    public Gson getGson(){
        return new Gson();
    }

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

//    @Bean
//    public LoginInterceptor loginInterceptor(){
//        return new LoginInterceptor();
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor())
//                .addPathPatterns("/")
//                .excludePathPatterns("/img");
//    }

        /**
     * 使用默认的HandlerAdapter
     * 对静态资源实行懒加载
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/img/**")
//                .addResourceLocations("/img/");
//    }
}
