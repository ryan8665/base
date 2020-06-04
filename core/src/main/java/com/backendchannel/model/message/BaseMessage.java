package com.backendchannel.model.message;


public abstract class BaseMessage implements Message {
    private String metaData;

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }
}
