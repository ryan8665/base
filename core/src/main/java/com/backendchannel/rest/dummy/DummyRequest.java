package com.backendchannel.rest.dummy;

import com.google.gson.annotations.SerializedName;
import com.backendchannel.model.message.rest.RestMessageRequest;

import org.springframework.http.HttpMethod;


public class DummyRequest extends RestMessageRequest {

    private String accNo;
    @SerializedName("URID")
    private String urid;

    @SerializedName("URPS")
    private String urps;


    public DummyRequest(String accNo, String urid, String urps) {
        this.accNo = accNo;
        this.urid = urid;
        this.urps = urps;
    }

    public String getUrid() {
        return urid;
    }

    public void setUrid(String urid) {
        this.urid = urid;
    }

    public String getUrps() {
        return urps;
    }

    public void setUrps(String urps) {
        this.urps = urps;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getAccNo() {
        return accNo;
    }

    @Override
    public String getMessage() {
        return accNo;
    }

    @Override
    public void setMessage(String message) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Class getResponseClass() {
        return DummyResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    //todo uri
    @Override
    public String getUri() {
        return "http://localhost:8080/test";
 //       return ApplicationConfig.getInstance().getCurrnecyBalanceUri() + "?acc_no=" + accNo + "&URID=" + urid + "&URPS=" + urps;
    }
}
