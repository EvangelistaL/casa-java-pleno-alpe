package com.case_alpe.charging_api.internal.listener;

import com.case_alpe.charging_api.api.entity.Boleto;
import com.case_alpe.charging_api.api.listener.BoletoListener;
import com.case_alpe.charging_api.api.usecase.ProcessBoleto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DefaultBoletoListener implements BoletoListener {

    private final ObjectMapper objectMapper;

    private final ProcessBoleto processBoleto;

    @Override
    public void listenBankslipTopic(String boleto) {
        try {
            log.info("Recebendo boleto para registro");
            Boleto boletoReceived = objectMapper.readValue(boleto, Boleto.class);
            this.processBoleto.execute(boletoReceived);
        } catch (RuntimeException e) {
            log.error("Erro no processamento da mensagem", e);
        } catch (JsonProcessingException e){
            log.error("Erro ao serializar boleto", e);
        }
    }
}
