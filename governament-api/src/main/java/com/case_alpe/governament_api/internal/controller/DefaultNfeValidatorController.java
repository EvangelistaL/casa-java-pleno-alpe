package com.case_alpe.governament_api.internal.controller;

import com.case_alpe.governament_api.api.controller.NfeValidatorController;
import com.case_alpe.governament_api.api.model.Nfe;
import com.case_alpe.governament_api.api.usecase.ValidateNfe;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@ConditionalOnSingleCandidate(NfeValidatorController.class)
public class DefaultNfeValidatorController implements NfeValidatorController{

    private final ValidateNfe validateNfe;

    @Override
    public boolean validateNfe(Nfe nfe) {
        return this.validateNfe.execute(nfe);
    }
}
