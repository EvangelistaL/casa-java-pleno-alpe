package com.casealpe.nfeapi.api.usecase;

import com.casealpe.nfeapi.api.entity.Involved;

import java.util.List;

public interface RetrieveCostumerApi {

    List<Involved> execute(com.casealpe.nfeapi.api.model.Involved involved);
}
