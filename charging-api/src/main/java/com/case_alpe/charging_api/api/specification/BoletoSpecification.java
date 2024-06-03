package com.case_alpe.charging_api.api.specification;

import com.case_alpe.charging_api.api.entity.QBoleto;
import com.querydsl.core.types.Predicate;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BoletoSpecification {

    private static final QBoleto qBoleto = QBoleto.boleto;

    public static Predicate findByBarCode(String barcode){
        return qBoleto.barCode.eq(barcode);
    }
}
