package com.cz.lookportnews.util;

import com.cz.lookportnews.entity.Comment;
import com.cz.lookportnews.entity.News;
import com.cz.lookportnews.entity.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ikidou.reflect.TypeBuilder;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import javax.persistence.ElementCollection;
import javax.persistence.criteria.Join;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;


public class GsonUtils {

    private static Gson gson=null;

    static{
         gson = new GsonBuilder()
                .serializeNulls()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .create();
    }

    /**
     *  反序列化 数组模式的json
     * @param json  json字符串
     * @param clazz 如：Response<List<News>>>  中的News.class
     * @param <T>
     * @return
     */
    public static <T> Response<List<T>> fromJsonArray(String json ,Class<T> clazz) {
        Type type = TypeBuilder
                .newInstance(Response.class)
                .beginSubType(List.class)
                .addTypeParam(clazz)
                .endSubType()
                .build();
        return gson.fromJson(json, type);
    }

    /**
     *  反序列化 对象模式
     * @param json json字符串
     * @param clazz Response<News>
     * @param <T>
     * @return
     */
    public static <T> Response<T> fromJsonObject(String json, Class<T> clazz) {
        Type type = TypeBuilder
                .newInstance(Response.class)
                .addTypeParam(clazz)
                .build();
        return gson.fromJson(json, type);
    }

    /**
     *  序列化对象为json字符串
     * @param obj
     * @return
     */
    public static String  toJson(Object obj){
        return gson.toJson(obj);
    }



    /**
     *  打印实体json
     */
    public static void printJson(Object object){
        gson.toJson(object,System.out);
    }


}
