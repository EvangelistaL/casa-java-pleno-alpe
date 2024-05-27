package com.casealpe.nfeapi.internal.usecase;

import com.casealpe.nfeapi.api.model.NfeGovernamentApi;
import com.casealpe.nfeapi.api.usecase.NfeValidatorApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DefaultNfeValidatorApi implements NfeValidatorApi {

    @Value("${governament-api.base-url}")
    private String baseUrl;

    @Override
    public boolean execute(NfeGovernamentApi nfe) {
        WebClient webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();

        Mono<Boolean> response = webClient.post()
                .uri("/validate-nfe", nfe)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(Boolean.class));

        return response.block().booleanValue();
    }
}
