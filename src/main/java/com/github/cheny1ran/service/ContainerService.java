package com.github.cheny1ran.service;

import com.github.cheny1ran.RancherAPI;
import com.github.cheny1ran.annotation.NotRecommendedUseAlone;
import com.github.cheny1ran.constant.RequestMethod;
import com.github.cheny1ran.model.Container;
import org.apache.commons.lang3.Validate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/7.
 */

@NotRecommendedUseAlone
public class ContainerService {
    private static final String NAMESPACE = "/containers";

    private static final String SEP = "/";

    private final RancherAPI API;

    private final static Class<Container> aclass = Container.class;

    public ContainerService(RancherAPI api) {
        this.API = api;
    }

    public Container create(Container container) throws IOException {
        Validate.notNull(container);
        return API.connect().request(NAMESPACE, aclass, container, RequestMethod.POST);
    }

    public void delete(String id) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id;
        API.connect().request(urlTail, aclass, RequestMethod.DELETE);
    }

    public Container update(String id, Container container) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id;
        return API.connect().request(urlTail, aclass, container, RequestMethod.PUT);
    }

    /**
     * todo 422
     */
    public Container actionConsole(String id) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id + "?action=console";
        return API.connect().request(urlTail, aclass, RequestMethod.POST);
    }

    public Container stop(String id) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id + "?action=stop";
        return API.connect().request(urlTail, aclass, RequestMethod.POST);
    }

    public Container stop(String id, boolean remove) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id + "?action=stop";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("remove", remove);
        return API.connect().request(urlTail, aclass, map, RequestMethod.POST);
    }

    public Container start(String id) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id + "?action=start";
        return API.connect().request(urlTail, aclass, RequestMethod.POST);
    }

    public Container restart(String id) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id + "?action=restart";
        return API.connect().request(urlTail, aclass, RequestMethod.POST);
    }

    public Container proxy(String id) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id + "?action=proxy";
        return API.connect().request(urlTail, aclass, RequestMethod.POST);
    }

    public Container proxy(String id, int port, boolean https) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id + "?action=proxy";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("port", port);
        map.put("scheme", https ? "https" : "http");
        return API.connect().request(urlTail, aclass, map, RequestMethod.POST);
    }

    public Container logs(String id) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id + "?action=logs";
        return API.connect().request(urlTail, aclass, RequestMethod.POST);
    }

    public Container logs(String id, boolean follow, int lines) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id + "?action=logs";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("follow", follow);
        map.put("lines", lines);
        return API.connect().request(urlTail, Container.class, map, RequestMethod.POST);
    }

    public Container execute(String id, List<String> commands) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id + "?action=execute";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("command", commands);
        return API.connect().request(urlTail, aclass, map, RequestMethod.POST);

    }

    public Container execute(String id, List<String> commands, boolean attachStdin, boolean attachStdout, boolean tty) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id + "?action=execute";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("command", commands);
        map.put("attachStdin", attachStdin);
        map.put("attachStdout", attachStdout);
        map.put("tty", tty);
        return API.connect().request(urlTail, Container.class, map, RequestMethod.POST);
    }


}
