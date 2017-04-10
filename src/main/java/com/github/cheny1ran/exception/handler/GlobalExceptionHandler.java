package com.github.cheny1ran.exception.handler;

import com.github.cheny1ran.exception.RancherIOException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/7.
 */

public class GlobalExceptionHandler {


    @ExceptionHandler(RancherIOException.class)
    public void handleRancherIOException(RancherIOException e) {

    }

}
