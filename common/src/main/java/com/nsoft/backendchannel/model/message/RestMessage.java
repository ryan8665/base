package com.nsoft.backendchannel.model.message;

public abstract class RestMessage extends BaseMessage {

    private String sequenceNumber;

    /**
     * Format request object as String
     *
     * @return Probably a JSON String
     */
    public abstract String getMessage();

    public abstract void setMessage(String message);

    @Override
    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Override
    public String getSequenceNumber() {
        return this.sequenceNumber;
    }

    @Override
    public String getMessageKey() {
        return getSequenceNumber();
    }
}
