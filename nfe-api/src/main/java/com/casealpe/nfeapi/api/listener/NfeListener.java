package com.casealpe.nfeapi.api.listener;

import org.springframework.kafka.annotation.KafkaListener;

public interface NfeListener {

    @KafkaListener(topics = "webhook.nfe", groupId = "group_nfe")
    void listenNfeTopic(String nfe);
}
