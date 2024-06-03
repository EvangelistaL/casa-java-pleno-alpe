package com.case_alpe.charging_api.internal.usecase;

import com.case_alpe.charging_api.api.entity.Boleto;
import com.case_alpe.charging_api.api.repository.BoletoRepository;
import com.case_alpe.charging_api.api.usecase.UpdateBoleto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultUpdateBoleto implements UpdateBoleto {

    private final BoletoRepository boletoRepository;

    @Override
    public Boleto execute(Boleto boleto) {
        return this.boletoRepository.save(boleto);
    }
}
