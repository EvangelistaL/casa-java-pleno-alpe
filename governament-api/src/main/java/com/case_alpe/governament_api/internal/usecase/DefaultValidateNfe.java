package com.case_alpe.governament_api.internal.usecase;

import com.case_alpe.governament_api.api.model.Nfe;
import com.case_alpe.governament_api.api.usecase.ValidateNfe;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DefaultValidateNfe implements ValidateNfe {

    @Override
    public boolean execute(Nfe nfe) {
        if (nfe.nfeNumber().length() != 9){
            return false;
        }
        return true;
    }
}
