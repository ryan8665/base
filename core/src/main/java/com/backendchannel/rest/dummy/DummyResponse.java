package com.backendchannel.rest.dummy;

import com.google.gson.annotations.SerializedName;
import com.backendchannel.model.message.rest.RestMessageResponse;


public class DummyResponse extends RestMessageResponse  {



    @SerializedName("BLNC")
    private String blnc;

    @Override
    public String toString() {
        return "This is String -- > " + blnc;
    }

    public String getBlnc() {
        return blnc;
    }

    public void setBlnc(String blnc) {
        this.blnc = blnc;
    }




    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public void setMessage(String message) {

    }
}
