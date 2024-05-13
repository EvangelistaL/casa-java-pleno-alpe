package com.casealpe.nfeapi.internal.listener;

import com.casealpe.nfeapi.api.listener.NfeListener;
import com.casealpe.nfeapi.api.model.Nfe;
import com.casealpe.nfeapi.api.usecase.CreateNfe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DefaultNfeListener implements NfeListener {

    private final CreateNfe createNfe;

    private final ObjectMapper objectMapper;

    @Override
    public void listenNfeTopic(String nfe) {
        try {
            log.info("Recebendo nfe");
            Nfe nfeReceived = objectMapper.readValue(nfe, Nfe.class);
            this.createNfe.execute(nfeReceived);
        } catch (RuntimeException e) {
            log.error("Erro no processamento da mensagem", e);
        } catch (JsonProcessingException e){
            log.error("Erro ao serializar nfe", e);
        }
    }
}
