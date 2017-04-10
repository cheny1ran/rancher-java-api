package com.github.cheny1ran.model;

import com.github.cheny1ran.model.common.PrimaryModel;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/4/6.
 */

@Data
public class Service extends PrimaryModel implements Serializable {

    private static final long serialVersionUID = -3574406501506751735L;

    private String id;

    private boolean assignServiceIpAddress = false;

    private String description;

    private String externalId;

    private LanchConfig lanchConfig;

    private LbTargetConfig lbconfig;

    private Map<String, String> matadata = new HashMap<String, String>();

    private String name;

    private List<PublicEndpoint> publicEndpoints = new ArrayList<PublicEndpoint>();

    private boolean retainIp;

    private int scale;

    private ScalePolicy scalePolicy;

    private List<SecondaryLaunchConfig> secondaryLaunchConfigs = new ArrayList<SecondaryLaunchConfig>();

    private String selectorContainer;

    private String selectorLink;

    private Stack stackId;

    private boolean startOnCreate = true;

    private String vip;

    private int createIndex;

    private int currentScale;

    private String fqdn;

    private String healthState;

    private List<Instance> instanceIds;

    private Map<String, Service> linkedServices = new HashMap<String, Service>();

    private boolean system = false;

    private ServiceUpgrade upgrade;

    public Service() {
        namespace = "/services";
    }

}
