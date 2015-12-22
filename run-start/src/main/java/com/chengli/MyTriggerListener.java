package com.chengli;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

/**
 * Created by chengli on 2015/12/18.
 */
public class MyTriggerListener implements TriggerListener {
    public String getName() {
        return "triggerListener";
    }

    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        System.out.println("triggerFired:" + context.getJobRunTime());
    }

    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        System.out.println("vetoJobExecution:" + context.getJobRunTime());
        return false;
    }

    public void triggerMisfired(Trigger trigger) {

    }

    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        System.out.println("triggerComplete :" + context.getJobRunTime());
    }
}
