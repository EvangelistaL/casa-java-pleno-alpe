package com.casealpe.nfeapi.internal.utils;

import com.casealpe.nfeapi.api.entity.Boleto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConvertBoletoDtoToEntity {

    public static Boleto convert(com.casealpe.nfeapi.api.model.Boleto boleto){
        Boleto boletoConverted = new Boleto();
        boletoConverted.setBarCode(boleto.barCode());
        boletoConverted.setStatus(boleto.status());
        boletoConverted.setValue(boleto.value());
        return boletoConverted;
    }
}
