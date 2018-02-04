package com.cz.lookportnews.controller;

import com.cz.lookportnews.entity.Channel;
import com.cz.lookportnews.services.admin.ChannelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    ChannelServices channelServices;

    @RequestMapping(value="/channelListPage")
    public String showChannelPage(){
        return "channel";
    }

    @RequestMapping(value = "/channelList")
    @ResponseBody
    public List<Channel> getChannelList(Long id ) {
        List<Channel> channelList = null;
        if(id==null){
            channelList = channelServices.findAll();
        } else {
//            channelList = channelServices.f
        }
        return channelList;
    }

}
