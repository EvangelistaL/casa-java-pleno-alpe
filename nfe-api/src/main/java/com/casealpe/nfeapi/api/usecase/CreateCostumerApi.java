package com.casealpe.nfeapi.api.usecase;

import com.casealpe.nfeapi.api.model.Costumer;
import reactor.core.publisher.Mono;

public interface CreateCostumerApi {

    Mono<Costumer> execute(Costumer costumer);
}
