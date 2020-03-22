package com.scheduler;

import org.apache.log4j.Logger;

public class SampleTask {
    final static Logger logger = Logger.getLogger(SampleTask.class);

    public void run() {
        logger.info("------------->> SampleTask");

    }

    public void runA() {
        logger.info("------------->> SampleTask");

    }
}
