package com.casealpe.alpecostumers.internal.controller;

import com.casealpe.alpecostumers.api.controller.CostumerController;
import com.casealpe.alpecostumers.api.entity.Costumer;
import com.casealpe.alpecostumers.api.specification.CostumerSpecification;
import com.casealpe.alpecostumers.api.usecase.CreateCostumer;
import com.casealpe.alpecostumers.api.usecase.RetrieveCostumer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@ConditionalOnSingleCandidate(CostumerController.class)
public class DefaultCostumerController implements CostumerController {

    private final RetrieveCostumer retrieveCostumer;

    private final CreateCostumer createCostumer;

    @Override
    public Costumer retrieveCostumerById(String identificationValue) {
        return retrieveCostumer.execute(CostumerSpecification.findByIdentificationValue(identificationValue));
    }

    @Override
    public Costumer createCostumer(Costumer costumer) {
        return createCostumer.execute(costumer);
    }
}
