package com.casealpe.nfeapi.api.specification;

import com.casealpe.nfeapi.api.entity.QInvolved;
import com.querydsl.core.types.Predicate;
import lombok.experimental.UtilityClass;

@UtilityClass
public class InvolvedSpecification {

    private static final QInvolved qInvolved = QInvolved.involved;

    public static Predicate findByIdentificationValue(String identificationValue){
        return qInvolved.identificationValue.eq(identificationValue);
    }
}
