package com.casealpe.nfeapi.api.specification;

import com.casealpe.nfeapi.api.entity.QBoleto;
import com.querydsl.core.types.Predicate;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BoletoSpecification {

    private static final QBoleto qBoleto = QBoleto.boleto;

    public static Predicate findById(Long id){
        return qBoleto.id.eq(id);
    }
}
