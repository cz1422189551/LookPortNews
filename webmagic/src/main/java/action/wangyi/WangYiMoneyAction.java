package action.wangyi;

import action.BaseAction;
import org.apache.http.util.TextUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import us.codecraft.webmagic.Page;
import utils.DateUtil;

import java.util.*;

public class WangYiMoneyAction extends BaseAction {

    Page page;

    String detailAll = "http://money.163.com/.*18//\\d+/\\w+\\.html";


    public WangYiMoneyAction(Page page) {
        this.page = page;
        StringBuilder sb = new StringBuilder(detailAll);
        //只抓取当天的页面
        detailAll = sb.insert(26, DateUtil.getMonthDay()).toString();

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
                Thread.sleep(clickSleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Set<String> setUrl = new HashSet<>();
        WebElement div = webDriver.findElement(
                By.xpath("//div[@class='news_main']"));
        List<WebElement> aList = div.findElements(By.tagName("a"));
        System.out.println("money : aList="+aList.size());


                for (WebElement webElement : aList) {
                    String url = webElement.getAttribute("href");
                    if (!TextUtils.isEmpty(url)) {
                        if (url.matches(detailAll)) {
                            setUrl.add(url);
                        }
                    }
                }
                System.out.println("money : detailSize ="+setUrl.size());
                page.addTargetRequests(new ArrayList<>(setUrl), 1);


    }

}
