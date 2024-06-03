package com.case_alpe.charging_api.internal.controller;

import com.case_alpe.charging_api.api.controller.BoletoController;
import com.case_alpe.charging_api.api.entity.Boleto;
import com.case_alpe.charging_api.api.specification.BoletoSpecification;
import com.case_alpe.charging_api.api.usecase.RetrieveBoleto;
import com.case_alpe.charging_api.api.usecase.UpdateBoleto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@ConditionalOnSingleCandidate(BoletoController.class)
public class DefaultBoletoController implements BoletoController{

    private final RetrieveBoleto retrieveBoleto;

    private final UpdateBoleto updateBoleto;

    @Override
    public Page<Boleto> retrieveBoletos(Pageable pageable) {
        return this.retrieveBoleto.execute(pageable, null);
    }

    @Override
    public Boleto retrieveBoletoByBarcode(String barcode) {
        return this.retrieveBoleto.execute(BoletoSpecification.findByBarCode(barcode));
    }

    @Override
    public Boleto updateBoleto(Boleto boleto) {
        return this.updateBoleto.execute(boleto);
    }
}
