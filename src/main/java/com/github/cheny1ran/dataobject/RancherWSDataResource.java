package com.github.cheny1ran.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/14.
 */
public class RancherWSDataResource implements Serializable{

    private static final long serialVersionUID = 6753917958879344320L;
    /**
     * container
     */
    protected String id;

    /**
     * container
     */
    protected String type;

    /**
     * 容器名
     */
    protected String name;

    protected String state;

    /**
     * 实际值是environment id
     */
    protected String accountId;

    protected Date created;

    protected String uuid;

    protected String healthState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getHealthState() {
        return healthState;
    }

    public void setHealthState(String healthState) {
        this.healthState = healthState;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RancherWSDataResource{");
        sb.append("id='").append(id).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", accountId='").append(accountId).append('\'');
        sb.append(", created=").append(created);
        sb.append(", uuid='").append(uuid).append('\'');
        sb.append(", healthState='").append(healthState).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
