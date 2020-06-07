package com.nsoft.exception;

import com.nsoft.util.Empty;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseException extends RuntimeException {
        private static final Logger log = Logger.getLogger(BaseException.class);
        protected List<String> messageArgs;
        protected Map<String, Object> params;
        private String message;

        public BaseException(String message, Throwable cause) {
            super(message, cause);
        }

        public BaseException() {
            log.error(this.getMessage(), this);
        }

        public BaseException(String message) {
            super(message);
            setMessage(message);
            log.error(this.getMessage(), this);
        }

        public BaseException(Throwable cause) {
            super(cause);
            log.error(this.getMessage(), this);
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public String getMessageArg(int index) {
            if (Empty.isEmpty(messageArgs)) {
                return "";
            } else {
                return messageArgs.get(index);
            }
        }

        public void addMessageArg(String messageArg) {
            if (Empty.isEmpty(this.messageArgs)) {
                this.messageArgs = new ArrayList<String>();
            }
            this.messageArgs.add(messageArg);
        }

        public Object[] getMessageArgs() {
            if (Empty.isNotEmpty(messageArgs)) {
                return messageArgs.toArray();
            }
            return null;
        }

        public void addParameter(String paramName, Object paramValue){
            if (params == null){
                params = new HashMap<String, Object>();
            }
            params.put(paramName, paramValue);
        }

        public Object getParameter(String paramName){
            if (params == null){
                return null;
            }
            return params.get(paramName);
        }
    }

