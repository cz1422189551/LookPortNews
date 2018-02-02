package com.cz.lookportnews.config;


import com.cz.lookportnews.entity.News;
import com.cz.lookportnews.services.NewsServices;
import com.cz.lookportnews.services.UserServices;
import org.springframework.context.annotation.*;




@Configuration()
@ImportResource(
        value={"classpath:config/spring-database.xml"}
)

@ComponentScan(
        basePackages = {"com.cz.lookportnews.services"}
)
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ServiceConfig  {


   @Bean("newsServices")
    public NewsServices getNewsServices(){
       NewsServices newsServices = new NewsServices();
       return newsServices;
   }

    @Bean()
    public UserServices getUserServices(){
        UserServices userServices = new UserServices();
        return userServices;
    }


    }





