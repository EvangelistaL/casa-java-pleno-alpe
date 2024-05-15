package com.casealpe.nfeapi.api.listener;

import com.casealpe.nfeapi.api.entity.Boleto;
import org.springframework.kafka.annotation.KafkaListener;

public interface BoletoListener {

    @KafkaListener(topics = "nfe.bank-slip.registered", groupId = "group_boleto")
    void listenBankSlipRegisteredTopic(Boleto boleto);

}
