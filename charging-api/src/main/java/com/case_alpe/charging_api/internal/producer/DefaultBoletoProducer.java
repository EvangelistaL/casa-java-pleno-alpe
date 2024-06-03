package com.case_alpe.charging_api.internal.producer;

import com.case_alpe.charging_api.api.entity.Boleto;
import com.case_alpe.charging_api.api.producer.BoletoProducer;
import com.casealpe.kafkaclient.api.usecase.KafkaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultBoletoProducer implements BoletoProducer {

    private static final String TOPIC = "nfe.bank-slip.registered";

    private final KafkaClient kafkaClient;

    @Override
    public void sendBankslipRegisteredEvent(Boleto boleto) {
        this.kafkaClient.sendMessage(boleto.toString(), TOPIC, boleto.getBarCode());
    }
}
