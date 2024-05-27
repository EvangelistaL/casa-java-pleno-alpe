package com.case_alpe.governament_api.api.controller;

import com.case_alpe.governament_api.api.model.Nfe;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/validate-nfe")
public interface NfeValidatorController {

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    boolean validateNfe(@RequestBody Nfe nfe);
}
