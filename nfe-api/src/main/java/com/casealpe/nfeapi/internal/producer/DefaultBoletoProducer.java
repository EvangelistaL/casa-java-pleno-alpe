package com.casealpe.nfeapi.internal.producer;

import com.casealpe.kafkaclient.api.usecase.KafkaClient;
import com.casealpe.nfeapi.api.entity.Boleto;
import com.casealpe.nfeapi.api.producer.BoletoProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultBoletoProducer implements BoletoProducer {

    private static final String TOPIC = "nfe.bank-slip";

    private final KafkaClient kafkaClient;

    @Override
    public void produce(Boleto boleto) {
        this.kafkaClient.sendMessage(boleto.toString(), TOPIC, boleto.getBarCode());
    }
}
