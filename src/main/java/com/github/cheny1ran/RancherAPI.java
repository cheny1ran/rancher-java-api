package com.github.cheny1ran;

import com.github.cheny1ran.constant.FinishUpgradeType;
import com.github.cheny1ran.http.RancherRequest;
import com.github.cheny1ran.http.RequestMethod;
import com.github.cheny1ran.model.common.PrimaryModel;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import java.io.IOException;
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
        log.info("authorization : " + authorization);
        return authorization;
    }

    public String getAuthorization() {
        return authorization;
    }

    public PrimaryModel create(PrimaryModel model) throws IOException {
        return this.connect().request(model.getNamespace(), model.getClass(), model, RequestMethod.POST);
    }

    public PrimaryModel delete(PrimaryModel model) throws IOException {
        Validate.notNull(model.getId());
        String urlTail = model.getNamespace() + SEP + model.getId();
        return this.connect().request(urlTail, model.getClass(), RequestMethod.DELETE);
    }

    public PrimaryModel update(PrimaryModel model) throws IOException {
        Validate.notNull(model.getId());
        String urlTail = model.getNamespace() + SEP + model.getId();
        return this.connect().request(urlTail, model.getClass(), model, RequestMethod.PUT);
    }

    public void finishUpgrade(String id, FinishUpgradeType type) throws IOException {
        Validate.notNull(id);
        String urlTail = SEP + type.getValue() + SEP + id + "?action=finishupgrade";
        this.connect().request(urlTail, type.getClz(), RequestMethod.POST);
    }


}
