package com.casealpe.alpecostumers.api.specification;

import com.casealpe.alpecostumers.api.entity.QCostumer;
import com.querydsl.core.types.Predicate;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CostumerSpecification {

    private static final QCostumer qCostumer = QCostumer.costumer;

    public static Predicate findByIdentificationValue(String identificationValue){
        return qCostumer.identificationValue.eq(identificationValue);
    }
}
