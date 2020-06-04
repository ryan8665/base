package com.backendchannel;


import com.backendchannel.model.message.Message;

public interface BackendConnector {
    Message executeRequest(Message requestMessage);
}