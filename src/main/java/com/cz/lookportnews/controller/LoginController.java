package com.cz.lookportnews.controller;

import com.cz.lookportnews.entity.admin.Admin;
import com.cz.lookportnews.services.ILoginServcies;
import com.cz.lookportnews.services.admin.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    AdminServices adminServices;


    @RequestMapping(value = "/admin",method= RequestMethod.POST)
    public String adminLogin(Admin admin){
        Admin admin1 = adminServices.validateAdmin(admin);
        ModelMap modelMap = new ModelMap();
        modelMap.put("admin",admin1);
        return "index";
    }


}
