package action.wangyi;

import action.BaseAction;
import org.apache.http.util.TextUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import us.codecraft.webmagic.Page;
import utils.DateUtil;

import java.util.*;

public class WangYiSportsAction extends BaseAction {

    Page page;

    String detailAll = "http://sports.163.com/.*18//\\d+/\\w+\\.html";


    public WangYiSportsAction(Page page) {
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
                Thread.sleep(800L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Set<String> urlSet = new HashSet<>();
        WebElement div = webDriver.findElement(
                By.xpath("//div[@class='col_con clearfix']"));
        List<WebElement> aList = div.findElements(By.tagName("a"));
        System.out.println("sports : aList ="+aList.size());

            for (WebElement webElement : aList) {
                String url = webElement.getAttribute("href");
                if (!TextUtils.isEmpty(url)) {
                    if (url.matches(detailAll)) {
                        urlSet.add(url);
                    }
                }
            }
            System.out.println("sports : detailSize ="+urlSet.size());
            List<String> urlList =new ArrayList<>(urlSet);
            page.addTargetRequests(urlList, 1);

    }


    public void filterUrl(List<String> hrefList) {

    }


}
