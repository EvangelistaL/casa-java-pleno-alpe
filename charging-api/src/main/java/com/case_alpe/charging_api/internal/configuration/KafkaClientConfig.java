package com.case_alpe.charging_api.internal.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.casealpe.kafkaclient"})
public class KafkaClientConfig {
}
