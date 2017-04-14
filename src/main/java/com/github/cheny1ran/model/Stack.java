package com.github.cheny1ran.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/15.
 */

@Data
public class Stack implements Serializable {

    private static final long serialVersionUID = 6564604078554575265L;

    public static final String NAMESPACE = "/stacks";

    private String id;

    private Binding binding;

    private String description;

    private String dockerCompose;

    private Map<String, String> environment = new HashMap<String, String>();

    private String externalId = "";

    private String group;

    @NotNull
    private String name;

    private Map<String, String> outputs = new HashMap<String, String>();

    private Map<String, String> previousEnvironment = new HashMap<String, String>();

    private String previousExternalId;

    private String rancherCompose;

    private boolean startOnCreate = true;

    private String healthState;

    private List<String> serviceIds = new ArrayList<String>();

    private boolean system = false;

    private String state;

    private String transitioning;

}
