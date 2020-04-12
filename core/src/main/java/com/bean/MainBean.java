package com.bean;

import com.ApplicationConfig;
import com.entity.AlirezaEntity;
import com.service.AlirezaService;

public class MainBean extends BaseBean{
   private ApplicationConfig applicationConfig;
   private AlirezaService alirezaservice;
   private String a ="aaaa";

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void setApplicationConfig(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    public void setAlirezaservice(AlirezaService alirezaservice) {
        this.alirezaservice = alirezaservice;
    }

    public void ali(){
        AlirezaEntity alirezaEntity = new AlirezaEntity();
        alirezaEntity.setTxt("alireza");
        alirezaEntity.setPassword("password");
        alirezaEntity.setRole("ROLE_USER");
//        alirezaEntity.setId(3);
        alirezaservice.persistAlireza(alirezaEntity);
    }

    public String doLogin(){
        return "success";
    }
}
