package com.bean;

import com.entity.AlirezaEntity;
import com.nsoft.ApplicationConfig;
import com.nsoft.bean.BaseBean;
import com.nsoft.service.UserService;
import com.service.AlirezaService;
import org.apache.log4j.Logger;

public class MainBean extends BaseBean {
    final static Logger logger = Logger.getLogger(MainBean.class);
   private ApplicationConfig applicationConfig;
   private AlirezaService alirezaservice;
   private UserService userService;


    public void setApplicationConfig(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
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
        try {
            userService.retrieveUserDetails();
        } catch (Exception e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return "success";
    }
}
