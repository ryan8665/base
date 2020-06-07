package com.nsoft.bean;

import com.nsoft.exception.BaseException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

import static org.apache.myfaces.shared.util.MessageUtils.getMessage;

public class BaseBean implements Serializable {

    protected void saveError(String clientId, String errorKey, Object messageArgs[]) {
        FacesMessage message = getMessage(errorKey, messageArgs);
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(clientId,message);

    }

    protected void saveInfo(String clientId, String errorKey, Object messageArgs[]) {
        FacesMessage message = getMessage(errorKey, messageArgs);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(clientId,message);

    }

    protected void saveWarning(String clientId, String errorKey, Object messageArgs[]) {
        FacesMessage message = getMessage(errorKey, messageArgs);
        message.setSeverity(FacesMessage.SEVERITY_WARN);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(clientId,message);
    }

    protected void saveError(BaseException e) {
        saveError("messagesPanel", e.getClass().getName(), e.getMessageArgs());
    }

    protected void saveWarning(BaseException e) {
        saveWarning("messagesPanel", e.getClass().getName(), e.getMessageArgs());
    }

    protected void saveInfo(BaseException e) {
        saveInfo("messagesPanel", e.getClass().getName(), e.getMessageArgs());
    }
}
