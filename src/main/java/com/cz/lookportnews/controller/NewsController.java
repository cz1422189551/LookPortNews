package com.cz.lookportnews.controller;

import com.cz.lookportnews.entity.Channel;
import com.cz.lookportnews.entity.News;
import com.cz.lookportnews.entity.admin.Admin;
import com.cz.lookportnews.services.NewsServices;
import com.cz.lookportnews.services.admin.ChannelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    NewsServices newsServices;

    @Autowired
    ChannelServices channelServices;

    @RequestMapping(value = "/insertPage", method = RequestMethod.GET)
    public String newsInsertPage(Model model, Long id) {

        System.out.println("changeListPage");
        List<Channel> channelList = null;
        if (id == null) {
            channelList = channelServices.findAll();
        } else {
//            channelList = channelServices.f
        }
        model.addAttribute("channelList", channelList);
        System.err.println(channelList.toString());
        return "news_add";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertNews(News news) {
        news.setTime(new Date());
        news.setCustomer(false);
        news.setOrigin("本地新闻");

        System.out.println(news.toString());
        //   News news1 = newsServices.saveNews(news);
        return "news_add";
    }

    @RequestMapping(value = "/insertFile", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertNewsAndFile(MultipartFile multipartFile , HttpServletRequest request) {
        System.out.println("insertNewsAndFile");
//        Map<String,Object>  map = new HashMap<>();
//        if(multipartFile!=null && !multipartFile.isEmpty()) {
//            String orignalFinalName = multipartFile.getOriginalFilename();
//
//            File outPath = new File(request.getServletContext().getRealPath("/"), "fileDir");
//            if (!outPath.exists() || !outPath.isDirectory()) {
//                outPath.mkdirs();
//            }
//            File file = new File(outPath, orignalFinalName);
//            try {
//                multipartFile.transferTo(file);
//                map.put("name" ,orignalFinalName);
//                map.put("path","http://localhost:8080/lookportnews/fileDir/"+orignalFinalName);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

//    }


            return null;
        }


    }
