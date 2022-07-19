package com.idolticketing.idolticketing.except;

import org.springframework.http.HttpStatus;

public class NotEqualLoginId extends RuntimeException {

    public NotEqualLoginId(String msg) {
        super(msg);
    }

}