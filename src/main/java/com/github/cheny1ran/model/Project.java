package com.github.cheny1ran.model;

import java.util.List;

/**
 * 功能描述:
 * A “project” in the API is referred to as an environment in the UI and Rancher documentation.
 *
 * @Author chen.yiran
 * @Date 17/3/6.
 */
@SuppressWarnings("unused")
public class Project {

    public final static String NAMESPACE = "/projects/";

    private String description;

    private List<ProjectMember> members;

    private String name;

    private ProjectTemplate projectTemplateId;

    private Boolean virtualMachine;

    private Network defaultNetworkId;

    private String healthState;

    private Integer id;

    private String orchestration;

    private String version;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProjectMember> getMembers() {
        return members;
    }

    public void setMembers(List<ProjectMember> members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectTemplate getProjectTemplateId() {
        return projectTemplateId;
    }

    public void setProjectTemplateId(ProjectTemplate projectTemplateId) {
        this.projectTemplateId = projectTemplateId;
    }

    public Boolean getVirtualMachine() {
        return virtualMachine;
    }

    public void setVirtualMachine(Boolean virtualMachine) {
        this.virtualMachine = virtualMachine;
    }

    public Network getDefaultNetworkId() {
        return defaultNetworkId;
    }

    public String getHealthState() {
        return healthState;
    }

    public Integer getId() {
        return id;
    }

    public String getOrchestration() {
        return orchestration;
    }

    public String getVersion() {
        return version;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Project{");
        sb.append("description='").append(description).append('\'');
        sb.append(", members=").append(members);
        sb.append(", name='").append(name).append('\'');
        sb.append(", projectTemplateId=").append(projectTemplateId);
        sb.append(", virtualMachine=").append(virtualMachine);
        sb.append(", defaultNetworkId=").append(defaultNetworkId);
        sb.append(", healthState='").append(healthState).append('\'');
        sb.append(", id=").append(id);
        sb.append(", orchestration='").append(orchestration).append('\'');
        sb.append(", version='").append(version).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
