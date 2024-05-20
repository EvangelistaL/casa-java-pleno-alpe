package com.casealpe.nfeapi.internal.usecase;

import com.casealpe.nfeapi.api.entity.Boleto;
import com.casealpe.nfeapi.api.repository.BoletoRepository;
import com.casealpe.nfeapi.api.usecase.UpdateBoleto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultUpdateBoleto implements UpdateBoleto {

    private final BoletoRepository boletoRepository;

    @Override
    public Boleto execute(Boleto boleto) {
        return this.boletoRepository.save(boleto);
    }

}
