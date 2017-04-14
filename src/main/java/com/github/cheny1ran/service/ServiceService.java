package com.github.cheny1ran.service;

import com.github.cheny1ran.RancherAPI;
import com.github.cheny1ran.annotation.NotRecommendedUseAlone;
import com.github.cheny1ran.constant.RequestMethod;
import com.github.cheny1ran.model.Service;
import org.apache.commons.lang3.Validate;

import java.io.IOException;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/4/14.
 */

@NotRecommendedUseAlone
public class ServiceService {
    private final static String NAMESPACE = "/services";

    private static final String SEP = "/";

    private final RancherAPI API;

    private final static Class<Service> aclass = Service.class;

    public ServiceService(RancherAPI api) {
        this.API = api;
    }

    public Service create(Service model) throws IOException {
        Validate.notNull(model);
        return API.connect().request(NAMESPACE, aclass, model, RequestMethod.POST);
    }
}
