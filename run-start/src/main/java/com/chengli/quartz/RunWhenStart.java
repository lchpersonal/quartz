package com.chengli.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.util.Date;
import java.util.Properties;

/**
 * quartz定时任务，想让服务启动就执行一次，然后再按照cron配置时间定时执行
 *
 * 设置两个参数：
 *  misfireInstruction 属性致为1
 *  startTime 属性设置一个已经过去的时间
 * Created by chengli on 2015/11/19.
 */
public class RunWhenStart {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put("org.quartz.threadPool.threadCount", "2");
        properties.put("org.quartz.threadPool.threadPriority", "5");
        SchedulerFactory sf = new StdSchedulerFactory(properties);
        Scheduler sched = sf.getScheduler();
        JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();
        CronTriggerImpl trigger = new CronTriggerImpl();
        trigger.setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_FIRE_ONCE_NOW);
        Date startTime = new Date();
        startTime.setTime(1447858389036L);
        trigger.setStartTime(startTime);
        trigger.setCronExpression("0 0/1 * ? * *");
        trigger.setName("mytrigger");
        // 注册并进行调度
        sched.scheduleJob(job, trigger);
        // 启动调度器
        sched.start();
    }
}
