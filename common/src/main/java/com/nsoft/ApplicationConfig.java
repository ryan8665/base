package com.nsoft;

import com.nsoft.util.AppContext;
import org.apache.log4j.Logger;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.text.ParseException;
import java.util.*;
import java.util.List;

import java.util.ResourceBundle;

public class ApplicationConfig {
    private static ApplicationConfig ourInstance;
    private ResourceBundle applicationConfig;
    private final static Logger log = Logger.getLogger(ApplicationConfig.class);

    public static ApplicationConfig getInstance() {
        if (ourInstance == null) {
            System.out.println("AppContext.getApplicationContext(): "+ AppContext.getApplicationContext());
            ourInstance = (ApplicationConfig) AppContext.getApplicationContext().getBean("applicationConfig");
        }
        return ourInstance;
    }

    private ApplicationConfig(String configFilePath) {
        try {
            applicationConfig = ResourceBundle.getBundle(configFilePath);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }



    public String getTimer() {
        return applicationConfig.getString("timer");
    }

    public String getTempFilesPath() {
        return applicationConfig.getString("/");
    }
}
