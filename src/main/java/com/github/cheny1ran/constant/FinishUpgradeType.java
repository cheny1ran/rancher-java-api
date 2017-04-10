package com.github.cheny1ran.constant;

import com.github.cheny1ran.model.Service;
import com.github.cheny1ran.model.Stack;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/4/7.
 */
public enum FinishUpgradeType {

    STACK("stacks", Stack.class), SERVICE("services", Service.class);

    private String value;

    private Class clz;

    public String getValue() {
        return value;
    }

    public Class getClz() {
        return clz;
    }

    FinishUpgradeType(String value, Class clz) {
        this.value = value;
        this.clz = clz;
    }
}
