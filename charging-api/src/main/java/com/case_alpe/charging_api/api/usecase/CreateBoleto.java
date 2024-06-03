package com.case_alpe.charging_api.api.usecase;

import com.case_alpe.charging_api.api.entity.Boleto;

public interface CreateBoleto {

    Boleto execute(Boleto boleto);
}
