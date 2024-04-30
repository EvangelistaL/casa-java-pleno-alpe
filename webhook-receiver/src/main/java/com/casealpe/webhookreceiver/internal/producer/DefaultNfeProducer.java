package com.casealpe.webhookreceiver.internal.producer;

import com.casealpe.kafkaclient.api.usecase.KafkaClient;
import com.casealpe.webhookreceiver.api.model.Nfe;
import com.casealpe.webhookreceiver.api.producer.NfeProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultNfeProducer implements NfeProducer {

    private static final String TOPIC = "webhook.nfe";

    private final KafkaClient kafkaClient;

    @Override
    public void produce(Nfe nfe) {
        this.kafkaClient.sendMessage(nfe.toString(), TOPIC, nfe.numeroNfe());
    }
}
