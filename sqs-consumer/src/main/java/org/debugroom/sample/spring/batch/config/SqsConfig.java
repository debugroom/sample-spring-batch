package org.debugroom.sample.spring.batch.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.config.QueueMessageHandlerFactory;
import org.springframework.cloud.aws.messaging.config.SimpleMessageListenerContainerFactory;
import org.springframework.cloud.aws.messaging.listener.QueueMessageHandler;
import org.springframework.cloud.aws.messaging.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("org.debugroom.sample.spring.batch.app.listener")
@Configuration
public class SqsConfig {

    @Value("${queue.endpoint}")
    private String queueEndpoint;
    @Value("${cloud.aws.region.static}")
    private String region;

    @Autowired
    AmazonSQSAsync amazonSQSAsync;

    @Bean
    public AwsClientBuilder.EndpointConfiguration endpointConfiguration(){
        return new AwsClientBuilder.EndpointConfiguration(queueEndpoint, region);
    }

}
