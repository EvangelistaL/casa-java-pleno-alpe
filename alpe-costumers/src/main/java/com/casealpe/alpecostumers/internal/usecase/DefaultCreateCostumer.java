package com.casealpe.alpecostumers.internal.usecase;

import com.casealpe.alpecostumers.api.entity.Costumer;
import com.casealpe.alpecostumers.api.repository.CostumerRepository;
import com.casealpe.alpecostumers.api.usecase.CreateCostumer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultCreateCostumer implements CreateCostumer {

    private CostumerRepository costumerRepository;

    @Override
    public Costumer execute(Costumer costumer) {
        return this.costumerRepository.save(costumer);
    }
}
