package com.casealpe.nfeapi.internal.utils;

import com.casealpe.nfeapi.api.entity.Involved;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConvertInvolvedDtoToEntity {

    public static Involved convert(com.casealpe.nfeapi.api.model.Involved involved){
        Involved involvedConverted = new Involved();
        involvedConverted.setLegalName(involved.legalName());
        involvedConverted.setIdentificationValue(involved.identificationValue());
        involvedConverted.setType(involved.type());
        return involvedConverted;
    }
}
