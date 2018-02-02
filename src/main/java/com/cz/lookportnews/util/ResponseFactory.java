package com.cz.lookportnews.util;

import com.cz.lookportnews.entity.Response;

/**
 * 工厂
 */
public class ResponseFactory {

    public final static int isConnected=-1;//连接不上服务器
    public final static int EntityNull=2;//实体的值为null
    public final static int CovertErorr=3;//数据转换格式错误
    public final static int ConnectedDataBaseError=4;  //服务器连接数据库出错
    public final static boolean Error=false;     //连接失败
    public final static boolean Success=true; //连接成功

    public final static int DeFalutSuccess=0; //默认没出现任何问题,为0

    public static final int INSERTFAILE=5;

    public static final int UPDATEFAILE=6;

    public static final int UPLOADERROR=7;

    public static final int IOEXCEPTION=8;

    public static final int MULTIPARTERROR=9;

    public static String errorMessage(int errorCode){

        if(errorCode==DeFalutSuccess)
            return "";

        switch (errorCode){
            case ConnectedDataBaseError:
                return "服务器连接数据库出错";
            case EntityNull:
                return "请求的实体为null";
            case CovertErorr:
                return "";
            case isConnected:
                return "连接不上服务器";
            case INSERTFAILE:
                return "提交失败";
            case UPDATEFAILE:
                return "修改失败";
            case IOEXCEPTION:
                return "存取文件有误";
            case MULTIPARTERROR:
                return "MULTIPARTERROR";

            default:
                return "未知错误";
        }
    }


    /**
     * 返回Response实体
     * @param <T>
     * @return
     */
    public static<T> Response<T> getResponse(T t){
        Response<T> response=null;
        if(t==null){
            response=dataIsNull();
        }else{
            response=new Response<>();
            response.setSuccess(Success);
            response.setErrorType(DeFalutSuccess);
            response.setErrorMessage(errorMessage(response.getErrorType()));
           response.setResult(t);
        }
        return response;
    }





    /**
     * 查询不到该数据
     * @param <T> typeName 实体名
     * @return
     */
    public static<T> Response<T>  dataIsNull(){
        Response<T> response =new Response<>();
        response.setSuccess(Success);
        response.setErrorType(EntityNull);
        response.setErrorMessage(errorMessage(response.getErrorType()));

        return response;
    }

    /**
     * 数据库链接出错
     * @param <T>
     * @return
     */
    public static<T> Response<T>  databaseNotConnection(){
        Response<T> response =new Response<>();
        response.setSuccess(Success);
        response.setErrorType(ConnectedDataBaseError);
        response.setErrorMessage(errorMessage(response.getErrorType()));

        return response;
    }

    /**
     * 数据转换异常
     * @param <T>
     * @return
     */
    public static<T> Response<T>  dataConvertException(){
        Response<T> response =new Response<>();
        response.setSuccess(Success);
        response.setErrorType(CovertErorr);
        response.setErrorMessage(errorMessage(response.getErrorType()));

        return response;
    }

    /**
     * 插入失败
     * @param
     * @return
     */
    public static Response  insertError(){
        Response response =new Response<>();
        response.setSuccess(Success);
        response.setErrorType(INSERTFAILE);
        response.setErrorMessage(errorMessage(response.getErrorType()));

        return response;
    }

    /**
     * 插入失败
     * @param
     * @return
     */
    public static Response  uploadIsNull(){
        Response response =new Response<>();
        response.setSuccess(Success);
        response.setErrorType(UPLOADERROR);
        response.setErrorMessage(errorMessage(response.getErrorType()));
        return response;
    }

    /**
     *  上传文件发生异常
     * @return
     */
    public static Response  saveFileExcetion(){
        Response response =new Response<>();
        response.setSuccess(Success);
        response.setErrorType(IOEXCEPTION);
        response.setErrorMessage(errorMessage(response.getErrorType()));

        return response;
    }



    /**
     * 修改失败
     * @param
     * @return
     */
    public static Response  updateError(){
        Response response =new Response<>();
        response.setSuccess(Success);
        response.setErrorType(UPDATEFAILE);
        response.setErrorMessage(errorMessage(response.getErrorType()));

        return response;
    }


    /**
     * 连接不上服务器
     * @param <T>
     * @return
     */
    public static<T> Response<T>  connectedFalse(){
        Response<T> response =new Response<>();
        response.setSuccess(Error);
        response.setErrorType(isConnected);
        response.setErrorMessage(errorMessage(isConnected));

        return response;
    }

    /**
     *
     * @param <T>
     * @return
     */
    public static<T> Response<T>  multipartError(){
        Response<T> response =new Response<>();
        response.setSuccess(Success);
        response.setErrorType(MULTIPARTERROR);
        response.setErrorMessage(errorMessage(MULTIPARTERROR));
        return response;
    }

}
