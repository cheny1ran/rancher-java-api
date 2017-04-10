package com.github.cheny1ran.model.common;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/4/7.
 */
public abstract class PrimaryModel {

    protected String namespace;

    public abstract String getId();

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
