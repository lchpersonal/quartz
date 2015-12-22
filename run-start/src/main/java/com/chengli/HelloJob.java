package com.chengli;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chengli on 2015/11/19.
 */
public class HelloJob implements Job {

    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("concurrentandparallel run~~" + df.format(new Date()));
    }
}
