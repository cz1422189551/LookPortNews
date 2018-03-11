package com.cz.lookportnews.webmagic.pipeline;

import com.cz.lookportnews.entity.Channel;
import com.cz.lookportnews.entity.News;
import com.cz.lookportnews.services.NewsServices;
import com.cz.lookportnews.webmagic.utils.DateUtil;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.FilePipeline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class MyFilePipeline extends FilePipeline {

    @Autowired
    NewsServices newsServices;

    static List<News> newsList = new ArrayList<>();

    public MyFilePipeline() {
        super();
    }
    public MyFilePipeline(String path) {
        super(path);
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        News news = checkNull(resultItems);
        if (news != null) {
            newsList.add(news);
        }
        if(newsList.size()>=100){
            newsServices.saveNews(newsList);
            newsList.removeAll(newsList);
        }
        super.process(resultItems, task);


    }

    public News checkNull(ResultItems resultItems) {
        News news = null;
        String pageUrl = resultItems.get("pageUrl").toString();
        String title = resultItems.get("title").toString();
        if (TextUtils.isEmpty(title))
            return null;
        String content = resultItems.get("content").toString();
        if (TextUtils.isEmpty(content))
            return null;
        String orignTmp = resultItems.get("orgin").toString().replace("\\\\s", "");
        String orin;
        String editor = "";
        String imgName = resultItems.get("imgName").toString();
        List<String> imgUrlList = resultItems.get("imgUrl");
        int size = imgUrlList.size();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= size; i++) {
            if (i == size) {
                sb.append(imgName).append(i).append(".jpg");
            } else {
                sb.append(imgName).append(i).append(".jpg").append(";");
            }
        }
        //分离来源
        int i = orignTmp.indexOf("：");
        int last = orignTmp.lastIndexOf("：");
        if (i != last) {
            //说明是有作者的
            orin = orignTmp.substring(i + 1, last - 3);
            editor = orignTmp.substring(last + 1);
        } else {
            //没有作者
            orin = orignTmp.substring(i + 1);
        }
        news = new News();
        news.setTitle(title);
        news.setContent(content);
        news.setTime(new Date());
        news.setOrigin(orin);
        news.setEditor(editor);
        news.setCustomer(false);
        news.setDescription("");
        news.setImgUrl(sb.toString());
        news.setPageSource(pageUrl);
        Channel channel = new Channel();
        channel.setId(getChannelId(DateUtil.checkTwoDomain(pageUrl)));
        news.setChannel(channel);
        return news;
    }

    public Long getChannelId(String preffix) {
        switch (preffix) {
            case "sports":
                return 1L;
            case "nba":
                return 2L;
            case "money":
                return 5L;
        }
        return 1L;
    }

}
