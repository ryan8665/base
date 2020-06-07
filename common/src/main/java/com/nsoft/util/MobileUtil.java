package com.nsoft.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class MobileUtil {
    public boolean isMobileClient() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        String userAgent = request.getHeader("User-Agent");
        return userAgent.contains("Mobi") ||
                userAgent.contains("Android") ||
                userAgent.contains("iPad") ||
                userAgent.contains("iPhone 6") ||
                userAgent.contains("Tablet");

    }
}
