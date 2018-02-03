package com.cz.lookportnews.controller;

import com.cz.lookportnews.entity.admin.Admin;
import com.cz.lookportnews.services.ILoginServcies;
import com.cz.lookportnews.services.admin.AdminServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    AdminServices adminServices;

    @Autowired
    Gson gson;


    @RequestMapping(value = "/admin",method= RequestMethod.POST)
    public String adminLogin(Admin admin , HttpServletRequest servletRequest,Model model){
        Admin admin1 = adminServices.validateAdmin(admin);

        if(admin1!=null){
            servletRequest.getSession().setAttribute("admin",admin1);
            model.addAttribute("admin",admin1);
            return "index";
        } else {
//            model.addFlashAttribute("login","账号或者密码错误");
            return "redirect:/login.jsp";
        }


    }

    @RequestMapping(value = "/adminJson",method= RequestMethod.POST)
    @ResponseBody
    public Admin adminLoginTest(String adminName , HttpServletRequest servletRequest,RedirectAttributes model){
        System.out.println("adminName " +adminName);
        Admin admin1 = adminServices.findOne(adminName);
        System.out.println(admin1.toString());
        return admin1;
    }

}
