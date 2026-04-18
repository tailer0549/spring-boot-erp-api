package com.ermproject.ERP.service.exceptions;

import org.hibernate.dialect.Database;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String msg) {
        super(msg);
    }
}
