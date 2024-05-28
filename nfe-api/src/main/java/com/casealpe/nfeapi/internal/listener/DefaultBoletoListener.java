package com.casealpe.nfeapi.internal.listener;

import com.casealpe.nfeapi.api.entity.Boleto;
import com.casealpe.nfeapi.api.listener.BoletoListener;
import com.casealpe.nfeapi.api.usecase.UpdateBoleto;
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

    private final UpdateBoleto updateBoleto;

    @Override
    public void listenBankSlipRegisteredTopic(String boleto) {
        try {
            log.info("Recebendo boleto processado");
            Boleto boletoReceived = objectMapper.readValue(boleto, Boleto.class);
            this.updateBoleto.execute(boletoReceived);
        } catch (RuntimeException e) {
            log.error("Erro no processamento da mensagem", e);
        } catch (JsonProcessingException e){
            log.error("Erro ao serializar nfe", e);
        }
    }
}
