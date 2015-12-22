package com.quartz.concurrent;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 可并行
 */
public class ConcurrentJob implements Job {

    private IRealJob realJob;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("并行job");
        realJob.run();
    }

    public void setRealJob(IRealJob realJob) {
        this.realJob = realJob;
    }
}
