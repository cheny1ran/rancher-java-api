package com.github.cheny1ran.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/4/6.
 */

@Data
public class ServiceBinding implements Serializable {

    private static final long serialVersionUID = 7025244593930061689L;

    private Map<String, String> labels;

    private List<String> ports;

}
