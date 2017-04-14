package com.github.cheny1ran.service;

import com.github.cheny1ran.RancherAPI;
import com.github.cheny1ran.annotation.NotRecommendedUseAlone;
import com.github.cheny1ran.constant.RequestMethod;
import com.github.cheny1ran.model.Stack;
import com.github.cheny1ran.model.StackUpgrade;
import org.apache.commons.lang3.Validate;

import java.io.IOException;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/4/14.
 */

@NotRecommendedUseAlone
public class StackService {

    private final static String NAMESPACE = "/stacks";

    private static final String SEP = "/";

    private final RancherAPI API;

    private final static Class<Stack> aclass = Stack.class;

    public StackService(RancherAPI api) {
        this.API = api;
    }

    public Stack create(Stack stack) throws IOException {
        Validate.notNull(stack);
        return API.connect().request(NAMESPACE, aclass, stack, RequestMethod.POST);
    }

    public Stack delete(String id) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id;
        return API.connect().request(urlTail, aclass, RequestMethod.DELETE);
    }

    public Stack update(String id, Stack model) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id;
        return API.connect().request(urlTail, aclass, model, RequestMethod.PUT);
    }

    public Stack finishUpgrade(String id) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id + "?action=finishupgrade";
        return API.connect().request(urlTail, aclass, RequestMethod.POST);
    }

    public Stack upgrade(String id, StackUpgrade stackUpgrade) throws IOException {
        Validate.notNull(id);
        Validate.notNull(stackUpgrade);
        String urlTail = NAMESPACE + SEP + id + "?action=upgrade";
        return API.connect().request(urlTail, aclass, stackUpgrade, RequestMethod.POST);
    }

    public Stack rollback(String id) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id + "?action=rollback";
        return API.connect().request(urlTail, aclass, RequestMethod.POST);
    }

    public Stack cancelUpgrade(String id) throws IOException {
        Validate.notNull(id);
        String urlTail = NAMESPACE + SEP + id + "?action=cancelupgrade";
        return API.connect().request(urlTail, aclass, RequestMethod.POST);
    }
}
