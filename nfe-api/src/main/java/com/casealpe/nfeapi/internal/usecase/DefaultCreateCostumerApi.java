package com.casealpe.nfeapi.internal.usecase;

import com.casealpe.nfeapi.api.model.Costumer;
import com.casealpe.nfeapi.api.usecase.CreateCostumerApi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultCreateCostumerApi implements CreateCostumerApi {

    @Value("${costumer-api.base-url}")
    private String baseUrl;

    @Override
    public Mono<Costumer> execute(Costumer costumer) {
        WebClient webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();

        return webClient.post()
                .uri(String.format("/costumers", costumer))
                .bodyValue(costumer)
                .retrieve()
                .bodyToMono(Costumer.class);
    }
}
