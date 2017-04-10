package com.github.cheny1ran.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/4/6.
 */

@Data
public class Binding implements Serializable{

    private static final long serialVersionUID = 4143098510845918828L;

    private Map<String,ServiceBinding> services;
}
