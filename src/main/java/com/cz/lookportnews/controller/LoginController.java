package com.cz.lookportnews.controller;

import com.cz.lookportnews.entity.admin.Admin;
import com.cz.lookportnews.services.ILoginServcies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class LoginController {


    @Autowired
    ILoginServcies<Admin> adminILoginServcies;

//    @Autowired<User>

    @RequestMapping(value = "/admin",method= RequestMethod.POST)
    public String adminLogin(Admin admin){
        ModelMap modelMap = new ModelMap();
      //  modelMap.put("")
        return "";
    }


}
