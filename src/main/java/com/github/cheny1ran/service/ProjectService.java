package com.github.cheny1ran.service;

import com.github.cheny1ran.exception.RancherAPIException;
import org.apache.log4j.Logger;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/6.
 */
public class ProjectService {

    private static final String NAMESPACE = "/projects";

    private static final Logger log = Logger.getLogger(ProjectService.class);

    private static final String SEP = "/";

    private String projectId = null;

    public void init(String projectId) {
        this.projectId = projectId;
    }

    public void validate() throws Exception {
        if (projectId == null) {
            throw new RancherAPIException("project id can't be null, please call the init method firse");
        }
    }
}
