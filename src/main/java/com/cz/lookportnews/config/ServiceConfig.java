package com.cz.lookportnews.config;


import com.cz.lookportnews.entity.News;
import com.cz.lookportnews.services.NewsServices;
import com.cz.lookportnews.services.UserServices;
import com.cz.lookportnews.webmagic.pageprocess.WangYiPageProcessor;
import com.cz.lookportnews.webmagic.pipeline.MyFilePipeline;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.*;


@Configuration()
@ImportResource(
        value = {"classpath:config/spring-database.xml"}
)

@ComponentScan(
        basePackages = {"com.cz.lookportnews.services", "com.cz.lookportnews.webmagic"}
)
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ServiceConfig {


    @Bean("newsServices")
    public NewsServices getNewsServices() {
        NewsServices newsServices = new NewsServices();
        return newsServices;
    }

    @Bean()
    public UserServices getUserServices() {
        UserServices userServices = new UserServices();
        return userServices;
    }

    @Bean()
    public MyFilePipeline getMyFilePipeline() {
        MyFilePipeline myFilePipeline = new MyFilePipeline("classpath:urls/");
        return myFilePipeline;
    }

//    @Bean
//    public WebDriver getWebDriver() {
//        //设置必要参数
//        DesiredCapabilities dcaps = new DesiredCapabilities();
////        //ssl证书支持
////        dcaps.setCapability("acceptSslCerts", true);
//        //截屏支持
//        dcaps.setCapability("takesScreenshot", false);
//        //css搜索支持
//        dcaps.setCapability("cssSelectorsEnabled", true);
//        //js支持
//        dcaps.setJavascriptEnabled(true);
//        //驱动支持
//        dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "D:\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
//
//        PhantomJSDriver driver = new PhantomJSDriver(dcaps);
//        return driver;
//    }

//    @Bean
//    public WangYiPageProcessor getWangYiPageProcessor(){
//        WangYiPageProcessor wangYiPageProcessor = new WangYiPageProcessor();
//        wangYiPageProcessor
//    }

}





