package com.casealpe.kafkaclient.internal.usecase;

import com.casealpe.kafkaclient.api.usecase.KafkaClient;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultKafkaClient implements KafkaClient {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String message, String topic, String key) {
        kafkaTemplate.send(topic, key, message);
    }
}
