package com.case_alpe.charging_api.api.producer;

import com.case_alpe.charging_api.api.entity.Boleto;

public interface BoletoProducer {

    void sendBankslipRegisteredEvent(Boleto boleto);
}
