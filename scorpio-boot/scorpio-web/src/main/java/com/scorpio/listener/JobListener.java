package com.scorpio.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class JobListener implements JobExecutionListener {
    private static final Logger log  = LoggerFactory.getLogger(JobListener.class);
    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;
    private long startTime;

    @Autowired
    public JobListener(ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }

    /**
     * 该方法会在job开始前执行
     */
    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();
        log.info("job before " + jobExecution.getJobParameters());
    }

    /**
     * 该方法会在job结束后执行
     */
    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("JOB STATUS : {}", jobExecution.getStatus());
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("JOB FINISHED");
            threadPoolTaskExecutor.destroy();
        } else if (jobExecution.getStatus() == BatchStatus.FAILED) {
            log.info("JOB FAILED");
        }
        log.info("Job Cost Time : {}/ms", (System.currentTimeMillis() - startTime));
    }
}
