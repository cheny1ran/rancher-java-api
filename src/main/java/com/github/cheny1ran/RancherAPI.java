package com.github.cheny1ran;

import com.github.cheny1ran.http.RancherRequest;
import com.github.cheny1ran.service.ContainerService;
import com.github.cheny1ran.service.ServiceService;
import com.github.cheny1ran.service.StackService;
import org.apache.log4j.Logger;

import java.util.Base64;

/**
 * 功能描述:
 * 1 rancherApi per thread per projectId(environment)
 *
 * @Author chen.yiran
 * @Date 17/3/6.
 */

@SuppressWarnings("unused")
public class RancherAPI {

    private final static Logger log = Logger.getLogger(RancherAPI.class);

    private final String url;

    private static Integer port = 8080;

    private final String accessKey;

    private final String secretKey;

    private final String projectId;

    private final String authorization;

    private static final String API_VERSION = "/v2-beta";

    private static final String PROJECT_PREFIX = "/projects";

    private static final String SEP = "/";

    public final ContainerService container = new ContainerService(this);

    public final StackService stack = new StackService(this);

    public final ServiceService service = new ServiceService(this);

    private RancherAPI(String rancherUrl, String accessKey, String secretKey, String projectId) {
        this.url = rancherUrl.endsWith(SEP) ? rancherUrl.substring(0, rancherUrl.length() - 1) : rancherUrl;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.projectId = projectId;
        this.authorization = generateAuthorization();
    }

    public static RancherAPI init(String url, String accessKey, String secretKey, String projectId) {
        return new RancherAPI(url, accessKey, secretKey, projectId);
    }

    public static RancherAPI init(String url, Integer port, String accessKey, String secretKey, String projectId) {
        RancherAPI.port = port;
        return new RancherAPI(url, accessKey, secretKey, projectId);
    }

    public RancherRequest connect() {
        return new RancherRequest(this);
    }

    public String concatUrl(String tailUrl) {
        String uurl = url.contains("http://") ? "" : "http://" + url + ":" + port + API_VERSION + PROJECT_PREFIX + SEP + projectId + (tailUrl.charAt(0) == '/' ? tailUrl : SEP + tailUrl);
        log.info("url : " + uurl);
        return uurl;
    }

    private String generateAuthorization() {
        String userpass = accessKey + ":" + secretKey;
        String authorization = "Basic " + Base64.getEncoder().encodeToString(userpass.getBytes()).trim();
        return authorization;
    }

    public String getAuthorization() {
        return authorization;
    }

    public String getUrl() {
        return url;
    }

    public String getProjectId() {
        return projectId;
    }
}
