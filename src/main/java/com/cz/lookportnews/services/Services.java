package com.cz.lookportnews.services;

import com.cz.lookportnews.entity.Response;

import java.util.List;
import java.util.Map;

public interface Services<T> {

    Response<T>  findone(String username);

    Response<List<T>>  findAll(String username);

    /**
     * 分页查询
     * @param pageNumber 页数
     * @param countSize 一页要获取多少记录
     * @return
     */
    Response<List<T>> queryAll(int pageNumber,int countSize);

    Response<T> insert(T t);

    Response<T> update(T t);

    Response<T> delete(T t);

    Map<String,Object>  findPage(Map<String,Object> param);

}
