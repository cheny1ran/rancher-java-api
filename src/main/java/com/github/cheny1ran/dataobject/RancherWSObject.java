package com.github.cheny1ran.dataobject;

import java.io.Serializable;
import java.util.Map;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/14.
 */
public class RancherWSObject implements Serializable {

    private static final long serialVersionUID = 6056837405358230184L;
    /**
     * 事件id
     */
    private String id;

    /**
     * 事件类型
     */
    private String name;

    /**
     * 和 RancherWSDataResource 中的id值一致
     */
    private String resourceId;

    private String resourceType;

    private Map<String,Object> data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RancherWSObject{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", resourceId='").append(resourceId).append('\'');
        sb.append(", resourceType='").append(resourceType).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
