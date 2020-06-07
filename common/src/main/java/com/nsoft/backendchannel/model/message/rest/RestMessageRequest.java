package com.nsoft.backendchannel.model.message.rest;


import com.nsoft.backendchannel.model.message.RestMessage;
import org.springframework.http.HttpMethod;


public abstract class RestMessageRequest extends RestMessage {

    public abstract Class getResponseClass();

    /**
     * Provide HTTP method of the request
     *
     * @return POST, GET , ...
     */
    public abstract HttpMethod getHttpMethod();

    public abstract String getUri();
}
