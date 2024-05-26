package com.casealpe.nfeapi.api.usecase;

import com.casealpe.nfeapi.api.entity.Nfe;

public interface ProcessNfe {

    Nfe execute(com.casealpe.nfeapi.api.model.Nfe nfe);

}
