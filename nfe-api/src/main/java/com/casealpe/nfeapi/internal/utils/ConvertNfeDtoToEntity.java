package com.casealpe.nfeapi.internal.utils;

import com.casealpe.nfeapi.api.entity.Boleto;
import com.casealpe.nfeapi.api.entity.Involved;
import com.casealpe.nfeapi.api.entity.Nfe;
import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class ConvertNfeDtoToEntity {

    public static Nfe convert(com.casealpe.nfeapi.api.model.Nfe nfe){
        Nfe nfeConverted = new Nfe();
        nfeConverted.setNfeNumber(nfe.nfeNumber());
        nfeConverted.setValue(nfe.value());
        nfeConverted.setStatus(nfe.status());
        setBoletos(nfeConverted, nfe);
        return nfeConverted;
    }

    private static void setBoletos(Nfe nfe, com.casealpe.nfeapi.api.model.Nfe nfeDto){
        Set<Boleto> boletos = nfeDto.boletos().stream()
                .map(ConvertBoletoDtoToEntity::convert)
                .collect(Collectors.toSet());
        nfe.setBoletos(boletos);
    }
}
