package com.casealpe.nfeapi.internal.usecase;

import com.casealpe.nfeapi.api.entity.Nfe;
import com.casealpe.nfeapi.api.repository.NfeRepository;
import com.casealpe.nfeapi.api.usecase.CreateNfe;
import com.casealpe.nfeapi.api.producer.BoletoProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomCreateNfe implements CreateNfe {

    private final NfeRepository nfeRepository;

    @Override
    public Nfe execute(com.casealpe.nfeapi.api.model.Nfe nfe) {

        return this.nfeRepository.save();
    }
}
