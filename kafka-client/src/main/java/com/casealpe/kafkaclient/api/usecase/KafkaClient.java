package com.casealpe.kafkaclient.api.usecase;

public interface KafkaClient {

    void sendMessage(String message, String topic, String key);
    
}
