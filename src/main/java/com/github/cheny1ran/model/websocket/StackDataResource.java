package com.github.cheny1ran.model.websocket;

import com.github.cheny1ran.dataobject.RancherWSDataResource;

import java.util.List;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/14.
 */
public class StackDataResource extends RancherWSDataResource {

    private static final long serialVersionUID = -7554670224577221979L;

    private String dockerCompose;

    private String rancherCompose;

    private List<String> serviceIds;

    private boolean startOnCreate;

    private boolean system;
    /**
     * 转变情况
     * yes 为正在转换 in progress
     * no  为未在转换 部署成功
     * error 为错误 transitioningMessage 包含详情
     */
    private String transitioning;

    private String transitioningMessage;

    public String getDockerCompose() {
        return dockerCompose;
    }

    public void setDockerCompose(String dockerCompose) {
        this.dockerCompose = dockerCompose;
    }

    public String getRancherCompose() {
        return rancherCompose;
    }

    public void setRancherCompose(String rancherCompose) {
        this.rancherCompose = rancherCompose;
    }

    public List<String> getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(List<String> serviceIds) {
        this.serviceIds = serviceIds;
    }

    public boolean isStartOnCreate() {
        return startOnCreate;
    }

    public void setStartOnCreate(boolean startOnCreate) {
        this.startOnCreate = startOnCreate;
    }

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

    public String getTransitioningMessage() {
        return transitioningMessage;
    }

    public void setTransitioningMessage(String transitioningMessage) {
        this.transitioningMessage = transitioningMessage;
    }

    public String getTransitioning() {
        return transitioning;
    }

    public void setTransitioning(String transitioning) {
        this.transitioning = transitioning;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StackDataResource{");
        sb.append("id='").append(id).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", accountId='").append(accountId).append('\'');
        sb.append(", created=").append(created);
        sb.append(", uuid='").append(uuid).append('\'');
        sb.append(", healthState='").append(healthState).append('\'');
        sb.append(", dockerCompose='").append(dockerCompose).append('\'');
        sb.append(", rancherCompose='").append(rancherCompose).append('\'');
        sb.append(", serviceIds=").append(serviceIds);
        sb.append(", startOnCreate=").append(startOnCreate);
        sb.append(", system=").append(system);
        sb.append(", transitioning='").append(transitioning).append('\'');
        sb.append(", transitioningMessage='").append(transitioningMessage);
        sb.append('}');
        return sb.toString();
    }
}
