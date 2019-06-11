package org.debugroom.sample.spring.batch.domain.repository;

import org.debugroom.sample.spring.batch.domain.model.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class SampleRepositoryImpl implements SampleRepository{

    @Autowired
    QueueMessagingTemplate queueMessagingTemplate;

    @Override
    public void save(Sample sample) {
        queueMessagingTemplate.convertAndSend("SampleSpringBatch", sample.getMessage());
    }

}
