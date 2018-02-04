package com.cz.lookportnews.controller;

import com.cz.lookportnews.entity.News;
import com.cz.lookportnews.entity.admin.Admin;
import com.cz.lookportnews.services.NewsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    NewsServices newsServices ;

    @RequestMapping(value="/insertPage" ,method= RequestMethod.GET)
    public String newsInsertPage(){
        return "news_add";
    }

    @RequestMapping
    public News insertNews(News news) {
        News news1 = newsServices.saveNews(news);
        return news1;
    }

}
