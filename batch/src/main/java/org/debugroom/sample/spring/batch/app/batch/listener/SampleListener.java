package org.debugroom.sample.spring.batch.app.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleListener extends JobExecutionListenerSupport {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info(this.getClass().getName() + "#beforeJob started.");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info(this.getClass().getName() + "#afterJob started.");
    }

}
