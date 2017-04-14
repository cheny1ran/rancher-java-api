package com.github.cheny1ran.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/4/14.
 */

@Data
public class StackUpgrade implements Serializable {
    private static final long serialVersionUID = 4522805756958974166L;

    private String dockerCompose;

    private Map<String, String> environment;

    private String externalId;

    private String rancherCompose;
}
