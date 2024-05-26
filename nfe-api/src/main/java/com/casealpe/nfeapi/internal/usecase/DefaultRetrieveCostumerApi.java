package com.casealpe.nfeapi.internal.usecase;

import com.casealpe.nfeapi.api.entity.Involved;
import com.casealpe.nfeapi.api.model.Costumer;
import com.casealpe.nfeapi.api.usecase.CreateCostumerApi;
import com.casealpe.nfeapi.api.usecase.RetrieveCostumerApi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultRetrieveCostumerApi implements RetrieveCostumerApi {

    @Value("${costumer-api.base-url}")
    private String baseUrl;

    private final CreateCostumerApi createCostumerApi;

    @Override
    public Involved execute(com.casealpe.nfeapi.api.model.Involved involved) {
            WebClient webClient = WebClient.builder()
                    .baseUrl(baseUrl)
                    .build();

            Mono<Costumer> costumer = webClient.get()
                    .uri(String.format("/costumers/%s", involved.identificationValue()))
                    .exchangeToMono(clientResponse -> {
                        if (clientResponse.statusCode().is4xxClientError()){
                            return createCostumerApi.execute(createCostumerBody(involved));
                        } else {
                            return clientResponse.createException().flatMap(Mono::error);
                        }
                    });

            return convertToInvolved(costumer.block());
    }

    private Involved convertToInvolved(Costumer costumer){
        Involved involved = new Involved();
        involved.setIdentificationValue(costumer.identificationValue());
        involved.setLegalName(costumer.legalName());
        return involved;
    }

    private Costumer createCostumerBody(com.casealpe.nfeapi.api.model.Involved involved){
        return new Costumer(null, involved.legalName(), involved.identificationValue());
    }
}
