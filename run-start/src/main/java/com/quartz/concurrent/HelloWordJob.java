package com.quartz.concurrent;

/**
 * Created by chengli on 2015/12/22.
 */
public class HelloWordJob implements IRealJob {

    @Override
    public void run() {
        System.out.println("hello word job run~~");
    }
}
