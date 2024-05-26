package com.casealpe.nfeapi.api.producer;

import com.casealpe.nfeapi.api.entity.Boleto;

public interface BoletoProducer {

    void sendBoletoEvent(Boleto boleto);
}
