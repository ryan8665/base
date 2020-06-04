package com.scheduler;

import com.backendchannel.BackendConnector;
import com.backendchannel.rest.dummy.DummyRequest;
import com.backendchannel.rest.dummy.DummyResponse;
import org.apache.log4j.Logger;

public class SampleTask {
    final static Logger logger = Logger.getLogger(SampleTask.class);
    private BackendConnector restConnector;

    public void setRestConnector(BackendConnector restConnector) {
        this.restConnector = restConnector;
    }

    public void run() {
        logger.info("------------->> SampleTask");

    }

    public void runA() {
        logger.info("------------->> SampleTask");
        DummyRequest request = new DummyRequest("11","22","33");

        DummyResponse response = (DummyResponse) restConnector.executeRequest(request);

        System.out.println(response.toString());


    }
}
