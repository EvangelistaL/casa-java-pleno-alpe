package com.casealpe.nfeapi.internal.controller;

import com.casealpe.nfeapi.api.controller.NfeController;
import com.casealpe.nfeapi.api.entity.Nfe;
import com.casealpe.nfeapi.api.specification.NfeSpecification;
import com.casealpe.nfeapi.api.usecase.RetrieveNfe;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@ConditionalOnSingleCandidate(NfeController.class)
public class DefaultNfeController implements NfeController{

    private final RetrieveNfe retrieveNfe;

    @Override
    public Page<Nfe> retrieveAll(Pageable pageable) {
        return this.retrieveNfe.execute(pageable, null);
    }

    @Override
    public Nfe retrieveNfeByNfeNumber(String nfeNumber) {
        return this.retrieveNfe.execute(NfeSpecification.findByNfeNumber(nfeNumber));
    }
}
