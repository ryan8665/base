package com.nsoft.backendchannel;


import com.nsoft.backendchannel.model.message.Message;

public interface BackendConnector {
    Message executeRequest(Message requestMessage);
}