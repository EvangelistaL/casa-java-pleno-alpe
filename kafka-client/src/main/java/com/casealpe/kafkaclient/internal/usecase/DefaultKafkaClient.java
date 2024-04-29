package com.casealpe.kafkaclient.internal.usecase;

import com.casealpe.kafkaclient.api.usecase.KafkaClient;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultKafkaClient<T> implements KafkaClient<T> {

    private final KafkaTemplate<String, T> kafkaTemplate;

    @Override
    public void sendMessage(T message, String topic, String key) {
        kafkaTemplate.send(topic, key, message);
    }
}
