package com.casealpe.kafkaclient.api.usecase;

public interface KafkaClient<T> {

    void sendMessage(T message, String topic, String key);
    
}
