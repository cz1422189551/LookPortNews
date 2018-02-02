package com.cz.lookportnews.entity;


import java.io.Serializable;


public class Response<T> implements Serializable {

    private static final long serialVersionUID = 5871459408880841442L;
    //是否连接
    private boolean success;
    //错误类型
    private int errorType ;
    //错误描述
    private String errorMessage;
    //实体
    private T result=null;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Response() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

//    @Override
//    public String toString() {
//        return "Response{" +
//                "success=" + success +
//                ", errorType=" + errorType +
//                ", errorMessage='" + errorMessage + '\'' +
//                ", result=" + result +
//                '}';
//    }
}
