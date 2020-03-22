package com;

import org.apache.log4j.Logger;

import java.util.ResourceBundle;

public class ApplicationConfig {
    final static Logger logger = Logger.getLogger(ApplicationConfig.class);
    private ResourceBundle applicationConfig;

    private ApplicationConfig(String configFilePath) {
        try {
            applicationConfig = ResourceBundle.getBundle(configFilePath);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public String getTimer() {
        return applicationConfig.getString("timer");
    }
}
