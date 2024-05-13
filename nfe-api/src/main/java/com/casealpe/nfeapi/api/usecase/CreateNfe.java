package com.casealpe.nfeapi.api.usecase;

import com.casealpe.nfeapi.api.entity.Nfe;

public interface CreateNfe {

    Nfe execute(com.casealpe.nfeapi.api.model.Nfe nfe);
}
