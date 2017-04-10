package com.github.cheny1ran.dataobject;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/14.
 */
public class RancherWSDataResource implements Serializable {

    private static final long serialVersionUID = 6753917958879344320L;
    /**
     * container
     */
    private String id;

    /**
     * container
     */
    private String type;

    /**
     * 容器名
     */
    private String name;

    private String state;

    /**
     * 实际值是environment id
     */
    private String accountId;

    private Date created;

    /**
     * 主机host id
     */
    private String hostId;

    /**
     * base image uuid
     */
    private String imageUuid;

    /**
     * 和type区别?
     */
    private String kind;

    /**
     * 开放端口
     */
    private List<String> ports;

    private String uuid;

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

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getImageUuid() {
        return imageUuid;
    }

    public void setImageUuid(String imageUuid) {
        this.imageUuid = imageUuid;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<String> getPorts() {
        return ports;
    }

    public void setPorts(List<String> ports) {
        this.ports = ports;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
        sb.append(", hostId='").append(hostId).append('\'');
        sb.append(", imageUuid='").append(imageUuid).append('\'');
        sb.append(", kind='").append(kind).append('\'');
        sb.append(", ports=").append(ports);
        sb.append(", uuid='").append(uuid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
