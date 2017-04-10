package com.github.cheny1ran.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/15.
 */
public class LogConfig implements Serializable{

    private static final long serialVersionUID = -6976008206903871705L;

    private String driver = "";

    private Map<String, String> config = new HashMap<String, String>();

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }
}

