package com.quartz.concurrent;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.ParseException;

/**
 * Created by chengli on 2015/12/22.
 */
public class JobTest {

    private static final boolean CONCURRENT = true;

    public static void main(String[] args) throws SchedulerException, ParseException {
        StdSchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        JobDataMap dataMap = new JobDataMap();
        dataMap.put("realJob", new HelloWordJob());
        JobDetail jobDetail = JobBuilder
                .newJob(CONCURRENT ? ConcurrentJob.class : SerialJob.class)
                .withIdentity("concurrentJob", "group")
                .setJobData(dataMap).build();
        CronTriggerImpl trigger = new CronTriggerImpl();
        trigger.setCronExpression("0/5 * * * * ?");
        trigger.setName("trigger");
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
