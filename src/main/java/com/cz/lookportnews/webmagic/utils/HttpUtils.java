package com.cz.lookportnews.webmagic.utils;


import com.arronlong.httpclientutil.builder.HCB;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpHeader;
import org.apache.http.Header;
import org.apache.http.impl.client.CloseableHttpClient;


public class HttpUtils {
    static CloseableHttpClient httpClient = null;
    static Header[] headers = null;
    //插件式配置请求参数（网址、请求参数、编码、client）


    static {
        try {
                httpClient = HCB.custom()
                    .timeout(5*1000)//超时
                   .pool(300, 50) //启用连接池，每个路由最大创建10个链接，总连接数限制为100个
                    .retry(5)        //重试5次
                    .build();
            headers = HttpHeader.custom()
                    .keepAlive("true")
                    .contentType(HttpHeader.Headers.APP_FORM_URLENCODED)
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HttpConfig getHttpConfig(){
        HttpConfig config = HttpConfig.custom()
                .headers(headers)    //设置headers，不需要时则无需设置
                //  .map(map)	//设置请求参数，没有则无需设置
                .encoding("utf-8")//设置请求和返回编码，默认就是Charset.defaultCharset()
                .client(httpClient);
        //.inenc("utf-8") //设置请求编码，如果请求返回一直，不需要再单独设置
        //.inenc("utf-8")	//设置返回编码，如果请求返回一直，不需要再单独设置
        //.json("json字符串")     //json方式请求的话，就不用设置map方法，当然二者可以共用。
        //.context(HttpCookies.custom().getContext()) //设置cookie，用于完成携带cookie的操作
        //.out(new FileOutputStream("保存地址"))		//下载的话，设置这个方法,否则不要设置
        //.files(new String[]{"d:/1.txt","d:/2.txt"})	//上传的话，传递文件路径，一般还需map配置，设置服务器保存路径
        return config ;
    }

    public static CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    public static void setHttpClient(CloseableHttpClient httpClient) {
        HttpUtils.httpClient = httpClient;
    }

    public static Header[] getHeaders() {
        return headers;
    }

    public static void setHeaders(Header[] headers) {
        HttpUtils.headers = headers;
    }
}
