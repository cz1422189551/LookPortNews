package com.cz.lookportnews.webmagic.pageprocess;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

public class BaseRepoPageprocessor implements PageProcessor {

    protected  static Site site ;



    //频道Url列表
    protected List<String> channelUrlList = new ArrayList<>();

    static{
        site  = Site
                .me()
                .setRetryTimes(5)
                .setSleepTime(3*1000)
                .setTimeOut(5000)
                .addHeader("Accept-Encoding", "gzip")
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36  (KHTML, like Gecko) Chrome/54.0.2840.59 Safari/537.36");
    }


    public String getChannelUrname(Page page){
        String s = page.getUrl().toString();
        return s.substring(7,s.indexOf("."));
    }

//    public String detailRexHeadAppend(String detailRex) {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder
//    }


    public List<String> getChannelUrlList() {
        return channelUrlList;
    }

    public void setChannelUrlList(List<String> channelUrlList) {
        this.channelUrlList = channelUrlList;
    }

    @Override
    public void process(Page page) {

    }

    @Override
    public Site getSite() {
        return site;
    }
}
