package com.casealpe.alpecostumers.internal.usecase;

import com.casealpe.alpecostumers.api.entity.Costumer;
import com.casealpe.alpecostumers.api.repository.CostumerRepository;
import com.casealpe.alpecostumers.api.usecase.RetrieveCostumer;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DefaultRetrieveCostumer implements RetrieveCostumer {

    private final CostumerRepository costumerRepository;

    @Override
    public Page<Costumer> execute(Pageable pageable, Predicate predicate) {
        if (predicate == null){
            return this.costumerRepository.findAll(pageable);
        }
        return this.costumerRepository.findAll(predicate, pageable);
    }

    @Override
    public Costumer execute(Predicate predicate) {
        return this.costumerRepository.findOne(predicate)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }
}
