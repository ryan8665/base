package com.scheduler;

import com.nsoft.backendchannel.BackendConnector;
import com.backendchannel.dummy.DummyRequest;
import com.backendchannel.dummy.DummyResponse;
import com.nsoft.scheduler.BaseScheduler;
import org.apache.log4j.Logger;

public class SampleTask extends BaseScheduler {
    final static Logger logger = Logger.getLogger(SampleTask.class);
    private BackendConnector restConnector;

    public void setRestConnector(BackendConnector restConnector) {
        this.restConnector = restConnector;
    }

    @Override
    public void run() {
        logger.info("------------->> SampleTask");
        DummyRequest request = new DummyRequest("11","22","33");

        DummyResponse response = (DummyResponse) restConnector.executeRequest(request);

        System.out.println(response.toString());
    }

    public void runA() {
        logger.info("------------->> SampleTask");



    }


}
