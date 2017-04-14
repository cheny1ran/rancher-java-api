package com.github.cheny1ran.model.websocket;

import com.github.cheny1ran.dataobject.RancherWSDataResource;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/14.
 */
public class ServiceDataResource extends RancherWSDataResource {

    private static final long serialVersionUID = -8342300003829010889L;

    private String stackId;

    private boolean startOnCreate;

    /**
     * 转变情况
     * yes 为正在转换 in progress
     * no  为未在转换 部署成功
     * error 为错误 transitioningMessage 包含详情
     */
    private String transitioning;

    private String transitioningMessage;

    public String getStackId() {
        return stackId;
    }

    public void setStackId(String stackId) {
        this.stackId = stackId;
    }

    public boolean isStartOnCreate() {
        return startOnCreate;
    }

    public void setStartOnCreate(boolean startOnCreate) {
        this.startOnCreate = startOnCreate;
    }

    public String getTransitioning() {
        return transitioning;
    }

    public void setTransitioning(String transitioning) {
        this.transitioning = transitioning;
    }

    public String getTransitioningMessage() {
        return transitioningMessage;
    }

    public void setTransitioningMessage(String transitioningMessage) {
        this.transitioningMessage = transitioningMessage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ServiceDataResource{");
        sb.append("id='").append(id).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", accountId='").append(accountId).append('\'');
        sb.append(", created=").append(created);
        sb.append(", uuid='").append(uuid).append('\'');
        sb.append(", healthState='").append(healthState).append('\'');
        sb.append(", stackId='").append(stackId).append('\'');
        sb.append(", startOnCreate=").append(startOnCreate);
        sb.append(", transitioning='").append(transitioning).append('\'');
        sb.append(", transitioningMessage='").append(transitioningMessage);
        sb.append('}');
        return sb.toString();
    }
}
