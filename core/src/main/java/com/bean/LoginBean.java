package com.bean;

import com.codahale.metrics.MetricRegistryListener;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginBean extends MetricRegistryListener.Base {
    Boolean accept = false;

    public void setAccept(Boolean accept) {
        this.accept = accept;
    }

    public Boolean getAccept() {
        return accept;
    }

    public void init(){
        accept = false;
    }

    public void test(){

    }


}
