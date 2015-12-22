package com.chengli;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * Created by chengli on 2015/12/18.
 */
public class MyJobListener implements JobListener {
    public String getName() {
        return "myjoblistener";
    }

    public void jobToBeExecuted(JobExecutionContext context) {
        System.out.println("jobToBeExecuted:" + context.getJobRunTime());
    }

    public void jobExecutionVetoed(JobExecutionContext context) {
        System.out.println("jobExecutionVetoed:" + context.getJobRunTime());
    }

    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        System.out.println("concurrentandparallel Was Executed:" + context.getJobRunTime());
    }
}
