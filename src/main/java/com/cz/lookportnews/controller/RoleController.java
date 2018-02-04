package com.cz.lookportnews.controller;


import com.cz.lookportnews.entity.Response;
import com.cz.lookportnews.entity.User;
import com.cz.lookportnews.services.Services;
import com.cz.lookportnews.services.admin.AdminServices;
import com.cz.lookportnews.services.admin.RoleServices;
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
public class RoleController {


    @Autowired
    RoleServices roleServices;

    @RequestMapping(value = "/roleListPage" ,method=RequestMethod.GET)
    public String showRolePage(){
        return "role";
    }


    @RequestMapping(
            value = "/roleList",
            method =RequestMethod.POST
    )
    @ResponseBody
    public Map<String,Object> adminPage(
            Integer pageSize,
            Integer pageNumber,
            String username,
            String password
    ){

        Map<String, Object> param=new HashMap<String, Object>();
        param.put("pageSize",pageSize);
        param.put("pageNumber",(pageNumber-1));
        Map<String,Object> result = roleServices.findPage(param);
        return result;
    }





}
