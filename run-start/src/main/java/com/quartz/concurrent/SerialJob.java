package com.quartz.concurrent;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by chengli on 2015/12/22.
 */
@DisallowConcurrentExecution
public class SerialJob implements Job {

    private IRealJob realJob;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("串行job");
        realJob.run();
    }


    //必须的
    public void setRealJob(IRealJob realJob) {
        this.realJob = realJob;
    }
}
