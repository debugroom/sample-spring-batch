package org.debugroom.sample.spring.batch.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqsConfig {

    @Value("${queue.endpoint}")
    private String queueEndpoint;
    @Value("${cloud.aws.region.static}")
    private String region;

    @Autowired
    AmazonSQSAsync amazonSQSAsync;

    @Bean
    public EndpointConfiguration endpointConfiguration(){
        return new EndpointConfiguration(queueEndpoint, region);
    }

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(){
        return new QueueMessagingTemplate(amazonSQSAsync);
    }

}
