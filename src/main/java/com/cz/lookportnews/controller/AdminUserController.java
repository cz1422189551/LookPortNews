package com.cz.lookportnews.controller;


import com.cz.lookportnews.entity.Response;
import com.cz.lookportnews.entity.User;

import com.cz.lookportnews.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminUserController {


    @Autowired
    Services<User> userServices;

    @Value("${saveFilePath}")
    private String saveFilePath;

    @RequestMapping(value = "/user" ,method=RequestMethod.GET)
    public String showUserHome(){
        return "admin_user";
    }



    @RequestMapping(
            value = "/user/create",
            method=RequestMethod.POST
    )
    @ResponseBody
    public Response<User> saveUser( @RequestBody  User user){
        System.out.println("saveUser");
        user.setCreatime(new Date());
        Response<User> userResponse =userServices.insert(user);
        return userResponse;
    }

    /**
     * 返回制定页数的 指定记录 如:第1页中的15条
     * @param pageNumber 请求页数
     * @param pageSize 一页当中取多少条记录
     * @return
     */
    @RequestMapping(
            value = "user/userList",
            method =RequestMethod.POST
    )
    @ResponseBody
    public Map<String,Object> userPage(
             Integer pageSize,
             Integer pageNumber,
             String username,
             String password
    ){
        System.out.println("userPage");
        System.out.println("pageSize " +pageSize);
        System.out.println("pageNumber" +pageNumber);
        Map<String, Object> param=new HashMap<String, Object>();
        param.put("pageSize",pageSize);
        param.put("pageNumber",(pageNumber-1));
        Map<String,Object> result = userServices.findPage(param);
        return result;
    }







}
