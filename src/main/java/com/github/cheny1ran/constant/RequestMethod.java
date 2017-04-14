package com.github.cheny1ran.constant;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/7.
 */
public enum RequestMethod {
    POST("POST"), GET("GET"), DELETE("DELETE"), PUT("PUT");

    private String method;

    private RequestMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
