package com.github.cheny1ran.exception;


import org.apache.log4j.Logger;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/6.
 */
public class RancherAPIException extends RuntimeException {

    private static final long serialVersionUID = -2779584069626861439L;

    private static final Logger log = Logger.getLogger(RancherAPIException.class);

    protected String message = "";

    protected ExceptionType code = ExceptionType.DEFAULT;


    public RancherAPIException(ExceptionType code, String message) {
        this.code = code;
        this.message = message;
        log.error(message);
    }

    public RancherAPIException(String message) {
        this.message = message;
        log.error(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ExceptionType getCode() {
        return code;
    }

}
