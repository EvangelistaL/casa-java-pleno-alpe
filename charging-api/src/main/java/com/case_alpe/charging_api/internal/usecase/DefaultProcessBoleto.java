package com.case_alpe.charging_api.internal.usecase;

import com.case_alpe.charging_api.api.entity.Boleto;
import com.case_alpe.charging_api.api.model.BoletoStatus;
import com.case_alpe.charging_api.api.producer.BoletoProducer;
import com.case_alpe.charging_api.api.specification.BoletoSpecification;
import com.case_alpe.charging_api.api.usecase.CreateBoleto;
import com.case_alpe.charging_api.api.usecase.ProcessBoleto;
import com.case_alpe.charging_api.api.usecase.RetrieveBoleto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultProcessBoleto implements ProcessBoleto {

    private final CreateBoleto createBoleto;

    private final RetrieveBoleto retrieveBoleto;

    private final BoletoProducer boletoProducer;

    @Override
    public Boleto execute(Boleto boleto) {
        return this.returnOrCreateBoleto(boleto);
    }

    private Boleto returnOrCreateBoleto(Boleto boleto){
        return retrieveBoleto.execute(Pageable.unpaged(), BoletoSpecification.findByBarCode(boleto.getBarCode()))
                .stream()
                .findFirst()
                .orElseGet(() -> persistBoleto(boleto));
    }

    private Boleto persistBoleto(Boleto boleto){
        boleto.setStatus(BoletoStatus.REGISTERED);
        boletoProducer.sendBankslipRegisteredEvent(boleto);
        boleto.setId(null);
        return this.createBoleto.execute(boleto);
    }
}
