package com.cz.lookportnews.exception;

import org.hibernate.sql.Insert;
import org.springframework.dao.DataAccessException;

public class InsertException extends DataAccessException {


    public InsertException(String msg) {
        super(msg);
    }




}
