package com.cz.lookportnews.webmagic.pageprocess;


import com.cz.lookportnews.webmagic.TestDriver;
import com.cz.lookportnews.webmagic.action.BaseAction;
import com.cz.lookportnews.webmagic.action.wangyi.WangYiMoneyAction;
import com.cz.lookportnews.webmagic.action.wangyi.WangYiNBAAction;
import com.cz.lookportnews.webmagic.action.wangyi.WangYiSportsAction;
import com.cz.lookportnews.webmagic.utils.DateUtil;
import org.openqa.selenium.WebDriver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理网易新闻的Page
 */
@Component
public class WangYiPageProcessor extends BaseRepoPageprocessor {



    public static final String SUBFFIX = ".163.com/";

    //网易新闻首页 （顶级爬取的域名）
    public static final String homeUrl = "http://www.163.com/";
    //网易新闻频道地址 （二级域名）
    public static final String channelRegex = "http://[^.]+.163.com/";
    //网易新闻详情文章（只匹配2018的文章）
    public static final String detailRegex = "18/\\d+/\\d+/\\w+\\.html";


    public static final String detailRegexAll = "http://.*/18/\\d+/\\d+/\\w+\\.html";


    public static List<String> channelUrlList = new ArrayList<>();

    public static StringBuffer sb = new StringBuffer(detailRegex);

    static {
//        channelUrlList.add("http://news.163.com/"); //网易新闻
//        channelUrlList.add("http://sports.163.com/"); //网易体育
        channelUrlList.add("http://sports.163.com/nba"); //网易NBA
//        channelUrlList.add("http://ent.163.com/"); //网易娱乐
        channelUrlList.add("http://money.163.com/"); //网易财经
//        channelUrlList.add("http://money.163.com/stock"); //网易股票
//        channelUrlList.add("http://auto.163.com/"); //网易汽车
//        channelUrlList.add("http://tech.163.com/"); //网易科技
//        channelUrlList.add("http://mobile.163.com/"); //网易手机
//        channelUrlList.add("http://digi.163.com/"); //网易数码
//        channelUrlList.add("http://house.163.com/"); //网易房产
//        channelUrlList.add("http://book.163.com/"); //网易读书
//        channelUrlList.add("http://jiangkuang.163.com/"); //网易健康
    }

    public WangYiPageProcessor() {

    }


    @Override
    public void process(Page page) {
        WebDriver webDriver = null;
        String pageUrl = page.getUrl().toString();
        if (homeUrl.equals(pageUrl)) {
            //初始化频道列表
            for (String s : channelUrlList) {
                page.addTargetRequests(channelUrlList, 0);
            }
        } else {

            if (page.getUrl().regex(detailRegexAll).match()) {
                //发送保存图片的目录名 如： sports , nba , money
                page.putField("imgDir", DateUtil.checkTwoDomain(pageUrl));
                //发送处理后的图片名 格式：xxx_180311DESHKLU05.jpg;
                page.putField("imgName", imgName(pageUrl));
                //发送页面中正文的图片链接
                page.putField("imgUrl",
                        page.getHtml().xpath("//div[@class='post_text']/p/img/@src").all());
                page.putField("pageSource", page.getHtml());
                //发送原文标题
                page.putField("pageUrl", pageUrl);
                //发送正文标题
                page.putField("title",
                        page.getHtml().xpath(
                                "//div[@class='post_content_main']/h1"));
                //发送来源
                page.putField("orign", page.getHtml().xpath("//div[@class='ep-source cDGray']/a/text()"));
                //发送正文
                page.putField("content",
                        page.getHtml().css("div.post_text")
                                .xpath("//p")
                                .all());
            } else {  //匹配该频道的所有详情页
                webDriver = TestDriver.getPhantomJSDriver();
                webDriver.get(pageUrl);
                System.out.println("pageUrl" + pageUrl);

                checkChannelName(pageUrl, webDriver, page);
            }

        }
        if (webDriver != null) {
            webDriver.quit();
        }

    }

    private void checkChannelName(String channelUrl, WebDriver webDriver, Page page) {
        BaseAction baseAction = null;
        String result = DateUtil.checkTwoDomain(channelUrl);
        System.out.println("result " + result);
        switch (result) {
            case "sports":
                baseAction = new WangYiSportsAction(page);
                break;
            case "nba":
                baseAction = new WangYiNBAAction(page);
                break;
            case "money":
                baseAction = new WangYiMoneyAction(page);
                break;
        }
        try {
            baseAction.loadMoreBtn(webDriver);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 处理图片名字
     *
     * @param url
     * @return
     */
    public String imgName(String url) {

        int twoDomain = url.indexOf("18");
        DateUtil.checkTwoDomain(url);
        System.out.println(twoDomain);
        return DateUtil.checkTwoDomain(url) + url.substring(twoDomain, url.length() - 5).replace("/", "");

    }


}
