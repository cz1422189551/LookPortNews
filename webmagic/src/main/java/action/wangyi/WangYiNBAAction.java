package action.wangyi;

import action.BaseAction;
import org.apache.http.util.TextUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import us.codecraft.webmagic.Page;
import utils.DateUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WangYiNBAAction extends BaseAction {

    Page page;

    String detailAll = "http://sports.163.com/.*18//\\d+/\\w+\\.html";


    public WangYiNBAAction(Page page) {
        this.page = page;
        StringBuilder sb = new StringBuilder(detailAll);
        //只抓取当天的页面
        detailAll = sb.insert(27, DateUtil.getMonthDay()).toString();
        System.out.println(detailAll);
    }


    @Override
    public void loadMoreBtn(WebDriver webDriver) throws InterruptedException {

//        webDriver.get(page.getUrl().toString());
        //过滤网易体育频道的
        WebElement loadMoreBtn = webDriver.findElement(
                By.className(btnName));
        for (int i = 0; i < clickTime; i++) {
            loadMoreBtn.click();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writeHtml(webDriver.getPageSource());
        Set<String> urlSet = new HashSet<>();
        WebElement div = webDriver.findElement(
                By.xpath("//div[@class='middle_part']"));
        List<WebElement> aList = div.findElements(By.tagName("a"));
        System.out.println("nba : aList ="+aList.size());
            for (WebElement webElement : aList) {
                String url = webElement.getAttribute("href");
                if (!TextUtils.isEmpty(url)) {
                    if (url.matches(detailAll)) {
                        urlSet.add(url);
                    }
                }
            }
            System.out.println("nba : detailSize ="+urlSet.size());
            List<String> urlList =new ArrayList<>(urlSet);
            page.addTargetRequests(urlList, 1);

    }
    public void writeHtml(String page){
        File file = new File("E://img//index.html");
        try {
            PrintWriter writer = new PrintWriter(file,"utf-8");
            writer.write(page);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
