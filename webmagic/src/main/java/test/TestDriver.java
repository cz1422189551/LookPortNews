package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageprocess.WangYiPageProcessor;
import pipeline.MyConsolePipeline;
import us.codecraft.webmagic.Spider;

public class TestDriver {

    public static void main(String[] args) {
      testTitile();
//        WebDriver driver=getPhantomJSDriver();
//        driver.get("http://www.baidu.com");
//        System.out.println(driver.getCurrentUrl());
//       // String url = "http://sports.163.com/nba/";

    }

    private static void testTitile() {
        String testDetail = "http://sports.163.com/nba/";

        String containStyle = "http://sports.163.com/18/0305/10/DC4KVHO20005877U.html";


        String car ="http://auto.163.com/";

        Spider.create(
                new WangYiPageProcessor()
        ).addUrl("http://www.163.com/")
                .addPipeline(new MyConsolePipeline())
                .thread(50)
                .runAsync();
    }


    public static PhantomJSDriver getPhantomJSDriver(){
        //设置必要参数
        DesiredCapabilities dcaps = new DesiredCapabilities();
//        //ssl证书支持
//        dcaps.setCapability("acceptSslCerts", true);
        //截屏支持
        dcaps.setCapability("takesScreenshot", false);
        //css搜索支持
        dcaps.setCapability("cssSelectorsEnabled", true);
        //js支持
        dcaps.setJavascriptEnabled(true);
        //驱动支持
        dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"D:\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");

        PhantomJSDriver driver = new PhantomJSDriver(dcaps);
        return  driver;
    }


}
