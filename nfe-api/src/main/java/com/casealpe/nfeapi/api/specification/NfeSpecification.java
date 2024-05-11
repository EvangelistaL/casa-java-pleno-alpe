package com.casealpe.nfeapi.api.specification;

import com.casealpe.nfeapi.api.entity.QNfe;
import com.querydsl.core.types.Predicate;
import lombok.experimental.UtilityClass;

@UtilityClass
public class NfeSpecification {

    private static final QNfe qNfe = QNfe.nfe;

    public static Predicate findByNfeNumber(String nfeNumber){
        return qNfe.nfeNumber.eq(nfeNumber);
    }
}
