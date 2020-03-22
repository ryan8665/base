package com.bean;

import com.ApplicationConfig;
import com.entity.AlirezaEntity;
import com.service.AlirezaService;
import org.springframework.security.access.prepost.PreAuthorize;

public class mainBean {
   private ApplicationConfig applicationConfig;
   private AlirezaService alirezaservice;

    public void setApplicationConfig(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    public void setAlirezaservice(AlirezaService alirezaservice) {
        this.alirezaservice = alirezaservice;
    }

    public void ali(){
        AlirezaEntity alirezaEntity = new AlirezaEntity();
        alirezaEntity.setTxt("aaa");
        alirezaservice.persistAlireza(alirezaEntity);
    }
}
