package com.nsoft.exception;

import java.util.List;

public class BaseException extends RuntimeException {
    protected List messageArgs;
    public Object[] getMessageArgs(){
        return messageArgs.toArray();
    }
}
