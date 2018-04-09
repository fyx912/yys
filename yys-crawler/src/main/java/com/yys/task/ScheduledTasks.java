package com.yys.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    //每分钟启动
    @Scheduled(cron = "0 0/1 * * * ?")
    public void timerToNow  (){
        // 间隔1分钟,执行任务
        Thread current = Thread.currentThread();
        System.out.println("定时任务1 \t:"+current.getId());
        logger.info("ScheduledTest.executeFileDownLoadTask 定时任务1:"+current.getId()+ ",name:"+current.getName());
    }


    @Async
    public void async() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("3");
    }
}
