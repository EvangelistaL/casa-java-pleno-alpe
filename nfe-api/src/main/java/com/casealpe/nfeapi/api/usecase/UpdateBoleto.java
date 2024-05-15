package com.casealpe.nfeapi.api.usecase;

import com.casealpe.nfeapi.api.entity.Boleto;

public interface UpdateBoleto {

    Boleto execute(Long id, Boleto boleto);
}
