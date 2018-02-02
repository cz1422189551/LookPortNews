package com.cz.lookportnews.controller;


import com.cz.lookportnews.entity.Response;
import com.cz.lookportnews.exception.InsertException;
import com.cz.lookportnews.util.ResponseFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;

import java.io.IOException;
import java.util.ArrayList;

@ControllerAdvice
@RestController
public class AppWideExceptionHandler {


    @ResponseBody
    public Response insertException() {
        System.out.println("insertException Handler");
        System.out.println("ceshi");
        Response response = ResponseFactory.insertError();
        response.setResult(new ArrayList<>());
        return response;
    }


    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response typeMismatchException() {
        System.out.println("转换类型有误");
        Response response = ResponseFactory.databaseNotConnection();
        response.setResult(new ArrayList<>());
        return response;
    }

    @ExceptionHandler(IOException.class)
    @ResponseBody
    public Response ioExcetionHandler() {
        System.out.println("上传的文件,写入硬盘发生异常");
        Response response = ResponseFactory.saveFileExcetion();
        response.setResult(new ArrayList<>());
        return response;
    }

            @ExceptionHandler(DataAccessException.class)
            @ResponseBody
            public Response dataAccessException(Exception e) {

            System.out.println(e.getMessage().toString());
            Response response = ResponseFactory.databaseNotConnection();
            response.setResult(new ArrayList<>());
            return response;
        }


    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Response allRuntimeException(Exception e) {
        System.out.println("服务器运行时异常 : " +e.getMessage().toString());
        Response response = ResponseFactory.databaseNotConnection();
        response.setResult(new ArrayList<>());
        return response;
    }

    @ExceptionHandler(InsertException.class)
    @ResponseBody
    public Response insertException(Exception e) {
        System.out.println("插入数据库异常 ：" +e.getMessage());
        Response response = ResponseFactory.insertError();
        response.setResult(new ArrayList<>());
        return response;
    }


    @ExceptionHandler(MultipartException.class)
    @ResponseBody
    public Response multipartException() {
        System.out.println("混合文件解析错误");
        Response response = ResponseFactory.multipartError();
        response.setResult(new ArrayList<>());
        return response;
    }

}


