package org.debugroom.sample.spring.batch.app.listener;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@EnableSqs
@Component
public class MessageListener {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @SqsListener(value = "SampleSpringBatch", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void onMessage(String message) throws
            JobExecutionAlreadyRunningException, JobRestartException,
            JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        Map<String, JobParameter> jobParameterMap = new HashMap<>();
        jobParameterMap.put("param", new JobParameter(message));
        JobParameters jobParameters = new JobParameters(jobParameterMap);
        JobExecution jobExecution = jobLauncher.run(job, jobParameters);
        ExecutionContext executionContext = jobExecution.getExecutionContext();
    }

}
