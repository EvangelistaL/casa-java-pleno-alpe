package com.casealpe.nfeapi.api.listener;

import org.springframework.kafka.annotation.KafkaListener;

public interface BoletoListener {

    @KafkaListener(topics = "nfe.bank-slip.registered", groupId = "group_boleto")
    void listenBankSlipRegisteredTopic(String boleto);

}
