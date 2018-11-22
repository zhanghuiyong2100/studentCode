package com.springboot.api.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @author 章辉勇
 * @创建时间 2018年11月20日
 * @描述: Job监听
 **/

public class CsvJobListener implements JobExecutionListener {

    long satrtTime;
    long endTime;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        satrtTime = System.currentTimeMillis();
        System.out.println("任务开始");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime = System.currentTimeMillis();
        System.out.println("任务结束，耗时" + (endTime - satrtTime) + "ms");

    }
}
