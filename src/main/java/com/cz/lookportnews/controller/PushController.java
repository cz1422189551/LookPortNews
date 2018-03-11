package com.cz.lookportnews.controller;

import com.cz.lookportnews.entity.Channel;
import com.cz.lookportnews.entity.News;
import com.cz.lookportnews.services.NewsServices;
import com.cz.lookportnews.services.admin.ChannelServices;
import com.cz.lookportnews.webmagic.pageprocess.WangYiPageProcessor;
import com.cz.lookportnews.webmagic.pipeline.ImageDownLoadPipLine;
import com.cz.lookportnews.webmagic.pipeline.MyConsolePipeline;
import com.cz.lookportnews.webmagic.pipeline.MyFilePipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.scheduler.FileCacheQueueScheduler;

import java.util.List;

@Controller
@RequestMapping("/push")
public class PushController {

    @Value("${tempFilePath}")
    public String imgRootPath;

    @Autowired
    NewsServices newsServices;
    @Autowired
    WangYiPageProcessor wangYiPageProcessor;
    @Autowired
    MyFilePipeline myFilePipeline;
    @Autowired
    ImageDownLoadPipLine imageDownLoadPipLine;


    @RequestMapping("/wangyi")
    public void pushWangyi(){
        System.out.println("pushWangyi");
        Spider.create(
                wangYiPageProcessor
        ).addUrl("http://www.163.com/")
//                .addPipeline(imageDownLoadPipLine)
                .addPipeline(myFilePipeline)
                .thread(50)
                .run();
    }

}
