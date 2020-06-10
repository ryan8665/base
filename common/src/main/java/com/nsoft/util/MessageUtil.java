package com.nsoft.util;

import com.nsoft.exception.BaseException;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;


public class MessageUtil {


    private static final Map<String, ResourceBundle> RESOURCE_BUNDLES = new HashMap<String, ResourceBundle>();
    static {
        init();
    }

    private static void init() {
        RESOURCE_BUNDLES.put("fa", ResourceBundle.getBundle("bundle/applicationMessages", new Locale("fa")));
        RESOURCE_BUNDLES.put("en", ResourceBundle.getBundle("bundle/applicationMessages", new Locale("en")));
    }

    public static String getMessage(ResourceBundle bundle, String msgKey, Object[] args) {
        String msgValue = getMessageValueForKey(bundle, msgKey);
        MessageFormat messageFormat = new MessageFormat(msgValue);
        return messageFormat.format(args);
    }

    public static String getMessage(String msgKey, Object[] args, String locale) {
        if(Empty.isEmpty(RESOURCE_BUNDLES)){
            init();
        }
        String msgValue = getMessageValueForKey(RESOURCE_BUNDLES.get(locale.toLowerCase()), msgKey);
        MessageFormat messageFormat = new MessageFormat(msgValue);
        return messageFormat.format(args);
    }

    public static String getMessage(ResourceBundle bundle, String msgKey) {
        return getMessageValueForKey(bundle, msgKey);
    }

    public static String getMessage(String msgKey, String locale) {
        if(Empty.isEmpty(RESOURCE_BUNDLES)){
            init();
        }
        return getMessageValueForKey(RESOURCE_BUNDLES.get(locale.toLowerCase()), msgKey);
    }

    private static String getMessageValueForKey(ResourceBundle bundle, String msgKey) {
        if(Empty.isEmpty(msgKey)){
            return "";
        }
        if (bundle.containsKey(msgKey)) {
            return bundle.getString(msgKey);
        }
        return "???" + msgKey + "???";
    }

    public static String getErrorMessage(ResourceBundle bundle, BaseException ex) {
        if (Empty.isNotEmpty(ex.getMessageArgs())) {
            return getMessage(bundle, ex.getClass().getName(), ex.getMessageArgs());
        }
        return getMessage(bundle, ex.getClass().getName());
    }


}
