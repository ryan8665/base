package com.nsoft.backendchannel.model.message;

import java.io.Serializable;


public interface Message extends Serializable {
    String getMetaData();

    void setMetaData(String metaData);

    void setSequenceNumber(String sequenceNumber);

    String getSequenceNumber();

    String getMessageKey();
}
