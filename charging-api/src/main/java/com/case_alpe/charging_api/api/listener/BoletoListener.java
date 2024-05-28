package com.case_alpe.charging_api.api.listener;

import org.springframework.kafka.annotation.KafkaListener;

public interface BoletoListener {

    @KafkaListener(topics = "nfe.bank-slip", groupId = "group_boleto")
    void listenBankslipTopic(String boleto);
}
