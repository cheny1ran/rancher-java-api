//package com.github.cheny1ran.service;
//
//import com.github.cheny1ran.RancherAPI;
//import com.github.cheny1ran.http.RequestMethod;
//import com.github.cheny1ran.model.Container;
//import org.apache.commons.lang3.Validate;
//
//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 功能描述:
// *
// * @Author chen.yiran
// * @Date 17/3/7.
// */
//
//@SuppressWarnings("unused")
//public class ContainerService {
//    private static final String NAMESPACE = "/containers";
//
//    private static final String SEP = "/";
//
//    private static volatile RancherAPI API = RancherAPI.INSTANCE;
//
////    private final String id;
//
//    public ContainerService(String id) {
////        this.id = id;
//    }
//
//    public ContainerService() {
//    }
//
//    public static Container create(@Valid Container container) {
//        return API.connect().request(NAMESPACE, Container.class, container, RequestMethod.POST);
//    }
//
//    public static void delete(@NotNull String id) {
//        Validate.notNull(id);
//        String urlTail = NAMESPACE + SEP + id;
//        API.connect().request(urlTail, Container.class, RequestMethod.DELETE);
//    }
//
//    public static Container update(@NotNull String id, @Valid Container container) {
//        Validate.notNull(id);
//        String urlTail = NAMESPACE + SEP + id;
//        return API.connect().request(urlTail, Container.class, container, RequestMethod.PUT);
//    }
//
//    /**
//     * todo 422
//     */
//    public static Container actionConsole(@NotNull String id) {
//        Validate.notNull(id);
//        String urlTail = NAMESPACE + SEP + id + "?action=console";
//        return API.connect().request(urlTail, Container.class, RequestMethod.POST);
//    }
//
//    public static Container stop(@NotNull String id) {
//        Validate.notNull(id);
//        String urlTail = NAMESPACE + SEP + id + "?action=stop";
//        return API.connect().request(urlTail, Container.class, RequestMethod.POST);
//    }
//
//    public static Container stop(@NotNull String id, boolean remove) {
//        Validate.notNull(id);
//        String urlTail = NAMESPACE + SEP + id + "?action=stop";
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("remove", remove);
//        return API.connect().request(urlTail, Container.class, map, RequestMethod.POST);
//    }
//
//    public static Container start(@NotNull String id) {
//        Validate.notNull(id);
//        String urlTail = NAMESPACE + SEP + id + "?action=start";
//        return API.connect().request(urlTail, Container.class, RequestMethod.POST);
//    }
//
//    public static Container restart(@NotNull String id) {
//        Validate.notNull(id);
//        String urlTail = NAMESPACE + SEP + id + "?action=restart";
//        return API.connect().request(urlTail, Container.class, RequestMethod.POST);
//    }
//
//    public static Container proxy(@NotNull String id) {
//        Validate.notNull(id);
//        String urlTail = NAMESPACE + SEP + id + "?action=proxy";
//        return API.connect().request(urlTail, Container.class, RequestMethod.POST);
//    }
//
//    public static Container proxy(@NotNull String id, int port, boolean https) {
//        Validate.notNull(id);
//        String urlTail = NAMESPACE + SEP + id + "?action=proxy";
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("port", port);
//        map.put("scheme", https ? "https" : "http");
//        return API.connect().request(urlTail, Container.class, map, RequestMethod.POST);
//    }
//
//    public static Container logs(@NotNull String id) {
//        Validate.notNull(id);
//        String urlTail = NAMESPACE + SEP + id + "?action=logs";
//        return API.connect().request(urlTail, Container.class, RequestMethod.POST);
//    }
//
//    public static Container logs(@NotNull String id, boolean follow, int lines) {
//        Validate.notNull(id);
//        String urlTail = NAMESPACE + SEP + id + "?action=logs";
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("follow", follow);
//        map.put("lines", lines);
//        return API.connect().request(urlTail, Container.class, map, RequestMethod.POST);
//    }
//
//    public static Container execute(@NotNull String id, List<String> commands) {
//        Validate.notNull(id);
//        String urlTail = NAMESPACE + SEP + id + "?action=execute";
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("command", commands);
//        return API.connect().request(urlTail, Container.class, map, RequestMethod.POST);
//
//    }
//
//    public static Container execute(@NotNull String id, List<String> commands, boolean attachStdin, boolean attachStdout, boolean tty) {
//        Validate.notNull(id);
//        String urlTail = NAMESPACE + SEP + id + "?action=execute";
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("command", commands);
//        map.put("attachStdin", attachStdin);
//        map.put("attachStdout", attachStdout);
//        map.put("tty", tty);
//        return API.connect().request(urlTail, Container.class, map, RequestMethod.POST);
//    }
//
//
//}
