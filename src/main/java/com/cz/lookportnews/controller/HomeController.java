package com.cz.lookportnews.controller;

import com.cz.lookportnews.entity.News;
import com.cz.lookportnews.entity.Response;
import com.cz.lookportnews.entity.User;
import com.cz.lookportnews.services.NewsServices;
import com.cz.lookportnews.services.Services;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/lookportnews")
public class HomeController {

  //  private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    NewsServices newsServices;
//    @Autowired
//    Services<User> userServices;

    @Value("${saveFilePath}")
    private String saveFilePath;


    @RequestMapping(
            value = "/newsList/all",
            method=RequestMethod.GET
    )
    @ResponseBody
    public Response<List<News>> getAllNewsList(){

        Response<List<News>> response = newsServices.getAllNews(true);
        System.out.println("controller" +response);

//        Gson gson = new Gson();
//        return gson.toJson(response);


         return response;
    }

//
//    @RequestMapping(
//            value = "/user/create",
//            method=RequestMethod.POST
//    )
//    @ResponseBody
//    public Response<User> saveUser(){
//        System.out.println("saveUser");
//        User user = new User();
//        user.setUsername("admin");
//        user.setPassword("admin");
//
//        Response<User> userResponse =userServices.insert(user);
//        return userResponse;
//    }

    /**
     * 返回制定页数的 指定记录 如:第1页中的15条
     * @param pageNumber 请求页数
     * @param countSize 一页当中取多少条记录
     * @return
     */
//    @RequestMapping(
//            value = "/repairlist/{pageNumber}/{countSize}",
//            method =RequestMethod.GET
//    )
//    @ResponseBody
//    public Response<List<Apply>> homeApplyPage(
//            @PathVariable("pageNumber") Integer pageNumber,
//            @PathVariable("countSize") Integer countSize
//    ){
//        System.out.println("homeApplyPage");
//        Response<List<Apply>> response =null;
//        response=applyService.queryAll(pageNumber,countSize);
//        for (Apply apply : response.getResult()) {
//            System.out.println(apply.toString());
//        }
//        return response;
//    }


//    /**
//     * 插入 维修记录
//     * @param apply
//     * @return
//     */
//    @RequestMapping(value = "/repair/new" ,method=RequestMethod.POST)
//    public Response<Apply> insertApply(
//            @RequestBody Apply apply
//    ){
//   //     LOG.debug("HomeController  ->  insertApply");
//
//        Response response =applyService.insert(apply);
//        if(response==null){
//            throw  new InsertException("HomeController");
//        }
//                return response;
//    }

//    @RequestMapping(value = "/saveimg",method=RequestMethod.POST)
//    public String saveFile(@RequestPart("img") MultipartFile file) {
//         //       LOG.debug("HomeController saveFile ");
//        System.out.println("HomeController saveFile ");
//        System.out.println("saveFilePath :" +saveFilePath);
//                String temp =String.valueOf(Utils.saveFile(file,saveFilePath));
//        System.out.println(temp);
//                return temp;
//    }


//    /**
//     * 处理上传文件
//     */
//    private void saveFile(MultipartFile[] files){
//        if(files!=null && files.length > 0) {
//            for (int i = 0; i <files.length; i++) {
//                Utils.saveFile(files[i],saveFilePath);
//            }
//        }
//    }
//
//
//
//
//
//
//
//    @ResponseBody
//    @RequestMapping(value = "/{id}",method =RequestMethod.GET)
//    public Response<Apply> findOneApply(
//            @PathVariable("id") String id
//    ){
//        System.out.println("findOneApply");
//
//        return   applyService.queryById(id);
//    }


//
//    @RequestMapping(method = RequestMethod.GET)
//    public ModelMap testPage(){
//        System.out.println("testPage");
//
//        ModelMap modelMap = new ModelMap();
//        modelMap.addAttribute("test","modelAndView");
//
//        return modelMap;
//    }
}
