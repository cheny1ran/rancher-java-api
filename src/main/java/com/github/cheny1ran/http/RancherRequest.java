package com.github.cheny1ran.http;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.cheny1ran.RancherAPI;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 功能描述:
 * request类 1.同步调用接口返回实时内容
 *
 * @Author chen.yiran
 * @Date 17/3/7.
 */
@SuppressWarnings("Duplicates")
public class RancherRequest {

    private final RancherAPI api;

    private final static Logger log = Logger.getLogger(RancherRequest.class);

    public static final ObjectMapper MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public RancherRequest(RancherAPI api) {
        this.api = api;
    }

    public <T> T request(String urlTail, Class<T> type, Object data, RequestMethod method, boolean hasOutput)
            throws IOException {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(api.concatUrl(urlTail));
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method.getMethod());
            connection.setDoOutput(hasOutput);
            setProps(connection);
            if (hasOutput) {
                MAPPER.writeValue(connection.getOutputStream(), data);
                log.info("Writed data " + data + " to outputStream");
            }
            connection.connect();

            return readConnInput(connection, type);

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public <T> T request(String urlTail, Class<T> type, Object data, RequestMethod method) throws IOException {
        return request(urlTail, type, data, method, true);
    }

    public <T> T request(String urlTail, Class<T> type, RequestMethod method) throws IOException {
        return request(urlTail, type, null, method, false);
    }

    public <T> T readConnInput(HttpURLConnection connection, Class<T> type) throws IOException {
        String rst = IOUtils.toString(connection.getInputStream());
        log.info("content from connection : " + rst);
        return MAPPER.readValue(rst, type);
    }

    public void setProps(HttpURLConnection connection) {
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", api.getAuthorization());
    }

}
