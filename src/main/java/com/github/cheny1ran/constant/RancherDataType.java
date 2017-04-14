package com.github.cheny1ran.constant;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/14.
 */

@SuppressWarnings("unused")
public class RancherDataType {

    /**
     * continer status
     */
    public final static String STARTING = "starting";
    public final static String CREATED = "created";
    public final static String RUNNING = "running";

    /**
     * stack & service status
     */
    public final static String ACTIVE = "active";
    public final static String ACTIVATING = "activating";
    public final static String INACTIVE = "inactive";
    public final static String STATE = "registering";
    public final static String UPGRADED = "upgraded";

    /**
     * resource type
     */
    public final static String CONTAINER = "container";
    public final static String CONTAINER_EVENT = "containerEvent";
    public final static String HOST = "host";
    public final static String STACK = "stack";
    public final static String SERVICE = "service";
    public final static String SERVICE_LOG = "serviceLog";

    /**
     * parameter name
     */
    public final static String RESOURCE_CHANGE_EVENT = "resource.change";
    public final static String RESOURCE = "resource";

    /**
     * health state
     */
    public final static String HEALTHY = "healthy";
    public final static String UNHEALTHY = "unhealthy";

    /**
     * transitioning status
     */
    public final static String TRANSITIONING_NO = "no";
    public final static String TRANSITIONING_YES = "yes";
    public final static String TRANSITIONING_ERROR = "error";

}
