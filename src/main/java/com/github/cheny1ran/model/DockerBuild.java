package com.github.cheny1ran.model;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/7.
 */
public class DockerBuild {

    private String dockerfile;

    private Boolean rm;

    public String getDockerfile() {
        return dockerfile;
    }

    public void setDockerfile(String dockerfile) {
        this.dockerfile = dockerfile;
    }

    public Boolean getRm() {
        return rm;
    }

    public void setRm(Boolean rm) {
        this.rm = rm;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DockerBuild{");
        sb.append("dockerfile='").append(dockerfile).append('\'');
        sb.append(", rm=").append(rm);
        sb.append('}');
        return sb.toString();
    }
}
