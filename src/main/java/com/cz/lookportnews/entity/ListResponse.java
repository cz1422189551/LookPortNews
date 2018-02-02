package com.cz.lookportnews.entity;

import java.util.List;

public class ListResponse<T> {


    public ListEntity<T> resut;

    public class ListEntity<T>{
        public Data<T> data;
    }
    public class Data<T> {
        public int total ;

        public List<T> list ;
    }


}
