package com.casealpe.nfeapi.internal.usecase;

import com.casealpe.nfeapi.api.entity.Nfe;
import com.casealpe.nfeapi.api.usecase.NfeValidatorApi;
import org.springframework.stereotype.Service;

@Service
public class DefaultNfeValidatorApi implements NfeValidatorApi {

    @Override
    public boolean execute(Nfe nfe) {
        return false;
    }
}
